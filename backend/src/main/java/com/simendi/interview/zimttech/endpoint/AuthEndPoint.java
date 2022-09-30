package com.simendi.interview.zimttech.endpoint;

import com.simendi.interview.zimttech.dto.ResponseData;
import com.simendi.interview.zimttech.exception.EndPointException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@RequestMapping("/auth")
public interface AuthEndPoint<LOGIN_DATA, RESPONSE_DTO> {

    @PostMapping("/logout")
    ResponseData logout(HttpServletRequest p_Request, HttpServletResponse p_Response) throws EndPointException;

    @PostMapping("/login")
    RESPONSE_DTO login(@RequestBody LOGIN_DATA login_data, HttpServletResponse p_Response, HttpServletRequest p_Request) throws EndPointException;
}