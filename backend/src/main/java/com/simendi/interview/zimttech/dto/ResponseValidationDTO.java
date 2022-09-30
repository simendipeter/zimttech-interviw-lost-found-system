package com.simendi.interview.zimttech.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Getter
@Setter
public class ResponseValidationDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -5800369745118333312L;
    private Boolean isValid;
    private String message;
}
