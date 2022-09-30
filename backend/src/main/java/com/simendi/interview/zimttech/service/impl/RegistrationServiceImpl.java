package com.simendi.interview.zimttech.service.impl;

import com.simendi.interview.zimttech.dao.UserDAO;
import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.dto.ResponseData;
import com.simendi.interview.zimttech.dto.ResponseValidationDTO;
import com.simendi.interview.zimttech.mapper.UserMapper;
import com.simendi.interview.zimttech.service.RegistrationService;
import com.simendi.interview.zimttech.statval.Constants;
import com.simendi.interview.zimttech.statval.Constants.Bean;
import com.simendi.interview.zimttech.util.APIErrorBuilder;
import com.simendi.interview.zimttech.validation.RequestValidator;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static com.simendi.interview.zimttech.statval.Constants.Path.REGISTER;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired private UserDAO userDAO;
    @Autowired private UserMapper userMapper;
    @Autowired @Qualifier(Bean.REGISTRATION_VALIDATOR) private RequestValidator<RequestRegistrationDTO> registrationValidator;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ResponseEntity register(RequestRegistrationDTO p_Request) throws ServiceException {
        ResponseEntity response;
        ResponseValidationDTO responseValidation = registrationValidator.validate(p_Request);
        if (responseValidation.getIsValid()) {
            userDAO.save(userMapper.convert(p_Request));
            response = ResponseEntity.ok(new ResponseData("200", "Success Register User"));
        }else {
            LOGGER.error("Request is not Valid {}", responseValidation.getMessage());
            response = new ResponseEntity<>(APIErrorBuilder.badRequest(RegistrationServiceImpl.class, responseValidation.getMessage(), Constants.Path.REGISTRATION.concat(REGISTER)), HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
