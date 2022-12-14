package com.simendi.interview.zimttech.endpoint.impl;

import com.simendi.interview.zimttech.dto.RequestLoginDTO;
import com.simendi.interview.zimttech.dto.ResponseData;
import com.simendi.interview.zimttech.endpoint.AuthEndPoint;
import com.simendi.interview.zimttech.exception.EndPointException;
import com.simendi.interview.zimttech.exception.ServiceException;
import com.simendi.interview.zimttech.model.User;
import com.simendi.interview.zimttech.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@RestController
public class AuthEndPointImpl implements AuthEndPoint<RequestLoginDTO, ResponseData> {
    @Autowired
    private DaoAuthenticationProvider authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthEndPointImpl.class);

    @Override
    public ResponseData logout(HttpServletRequest p_Request, HttpServletResponse p_Response) throws EndPointException {
        ResponseData result = new ResponseData("500", "Logout Failed");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            authenticationService.logout(p_Request, p_Response, auth);
            LOGGER.info("Logout Successful");
            try {
                authenticationService.updateStatusLoggedOut(auth.getName());
            } catch (ServiceException e) {
                LOGGER.error("Error Update Status Logged Out {}", e.toString());
            }
            result = new ResponseData("200", "Logout Success");
        }else {
            LOGGER.error("Logout Failed");
        }
        return result;
    }

    @Override
    public ResponseData login(@RequestBody RequestLoginDTO p_RequestLoginDTO, HttpServletResponse p_HttpServletResponse, HttpServletRequest p_Request) throws EndPointException {
        ResponseData result = new ResponseData("500", "Login Failed");
        if (p_RequestLoginDTO.getPassword() != null && p_RequestLoginDTO.getUserName() != null) {
            User userDetails = null;
            try {
                userDetails = authenticationService.login(p_RequestLoginDTO.getUserName());
            } catch (ServiceException e) {
                LOGGER.error("Error Login {}", e.toString());
            }
            if (userDetails != null) {
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(p_RequestLoginDTO.getUserName(), p_RequestLoginDTO.getPassword()));
                if (authentication.isAuthenticated()) {
                    try {
                        authenticationService.updateStatusLoggedIn(userDetails);
                    } catch (ServiceException e) {
                        LOGGER.error("Error update status logged in : {}", e.toString());
                    }
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    result = new ResponseData("200", "Login Success");
                }
            }else {
                LOGGER.info("User Not Found");
                result = new ResponseData("500", "User Not Exist");
            }
        }else {
            LOGGER.error("Missing Login Body Request");
        }
        return result;
    }
}