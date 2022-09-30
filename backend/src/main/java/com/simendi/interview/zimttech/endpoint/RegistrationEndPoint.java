package com.simendi.interview.zimttech.endpoint;

import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface RegistrationEndPoint {

    ResponseEntity register(@RequestBody RequestRegistrationDTO p_Request) throws EndPointException;
}
