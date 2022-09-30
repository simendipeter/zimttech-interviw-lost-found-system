package com.simendi.interview.zimttech.validation;

import com.simendi.interview.zimttech.dto.ResponseValidationDTO;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 * @param <REQUEST_DTO>
 */
public interface RequestValidator<REQUEST_DTO> {

    ResponseValidationDTO validate(REQUEST_DTO p_Request);
}
