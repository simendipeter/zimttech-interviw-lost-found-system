package com.simendi.interview.zimttech.validation;

import com.simendi.interview.zimttech.dao.UserDAO;
import com.simendi.interview.zimttech.dto.RequestRegistrationDTO;
import com.simendi.interview.zimttech.dto.ResponseValidationDTO;
import com.simendi.interview.zimttech.exception.DAOException;
import com.simendi.interview.zimttech.model.User;
import com.simendi.interview.zimttech.statval.Constants.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Service
@Qualifier(value = Bean.REGISTRATION_VALIDATOR)
public class RegistrationValidator implements RequestValidator<RequestRegistrationDTO> {

    @Autowired private UserDAO userDAO;
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationValidator.class);

    @Override
    public ResponseValidationDTO validate(RequestRegistrationDTO p_Request) {
        ResponseValidationDTO result = new ResponseValidationDTO();
        result.setIsValid(false);
        if (p_Request.getMobileNumber() != null && p_Request.getMobileNumber().length() > 0) {
            if (GeneralValidation.isValidPhoneNumber(p_Request.getMobileNumber())) {
                User user = null;
                try {
                    user = userDAO.findByMobileNumber(p_Request.getMobileNumber());
                } catch (DAOException e) {
                    LOGGER.error("Error searching user by mobile number {} : {}", p_Request.getMobileNumber(), e.toString());
                }
                if (user == null) {
                    if (p_Request.getFirstName() != null && p_Request.getFirstName().length() > 0) {
                        if (p_Request.getLastName() != null && p_Request.getFirstName().length() > 0) {
                            if (p_Request.getEmail() != null && p_Request.getEmail().length()> 0) {
                                if (GeneralValidation.isValidEmail(p_Request.getEmail())) {
                                    try {
                                        user = userDAO.findByEmail(p_Request.getEmail());
                                    } catch (DAOException e) {
                                        LOGGER.error("Error find User By Email {} : {}", p_Request.getEmail(), e.toString());
                                    }
                                    if (user == null) {
                                        result.setIsValid(true);
                                    }else {
                                        result.setMessage("User with email "+p_Request.getEmail()+" has already exist");
                                    }
                                }else {
                                    result.setMessage("Email must be in valid format");
                                }
                            }else {
                                result.setMessage("Email can not be null & length must be > 0");
                            }
                        }else {
                            result.setMessage("Last Name can not be null & length must be > 0");
                        }
                    }else {
                        result.setMessage("First Name can not be null & length must be > 0");
                    }
                }else {
                    result.setMessage("User with Phone Number "+p_Request.getMobileNumber()+" is exist");
                }
            }else {
                result.setMessage("Phone Number must be in valid Indonesia format");
            }
        }else {
            result.setMessage("Mobile Phone can not be null & length must be > 0");
        }
        return result;
    }
}
