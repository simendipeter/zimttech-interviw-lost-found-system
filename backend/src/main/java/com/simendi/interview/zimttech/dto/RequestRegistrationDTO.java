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
public class RequestRegistrationDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3198880434676247053L;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String dob;
    private Integer gender;
    private String email;
}
