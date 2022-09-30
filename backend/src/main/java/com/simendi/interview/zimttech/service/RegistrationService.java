package com.simendi.interview.zimttech.service;

import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.exception.ServiceException;
import org.springframework.http.ResponseEntity;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface RegistrationService {

    ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException;
}
