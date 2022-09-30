package com.simendi.interview.zimttech.endpoint.impl;

import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.endpoint.RegistrationEndPoint;
import com.simendi.interview.zimttech.exception.EndPointException;
import com.simendi.interview.zimttech.exception.ServiceException;
import com.simendi.interview.zimttech.service.RegistrationService;
import com.simendi.interview.zimttech.statval.Constants;
import com.simendi.interview.zimttech.util.APIErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.simendi.interview.zimttech.statval.Constants.Path.REGISTER;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@RestController
@RequestMapping(Constants.Path.REGISTRATION)
public class RegistrationEndPointImpl implements RegistrationEndPoint {

    @Autowired private RegistrationService registrationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationEndPointImpl.class);

    @PostMapping(Constants.Path.REGISTER)
    @Override
    public ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException {
        try {
            return registrationService.register(p_Request);
        } catch (ServiceException e) {
            LOGGER.error("Error conduct register : {}", e.toString());
            return new ResponseEntity<>(APIErrorBuilder.internalServerError(RegistrationEndPointImpl.class, "Error Register Process : "+e.getMessage(), Constants.Path.REGISTRATION.concat(REGISTER)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
