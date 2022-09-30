package com.simendi.interview.zimttech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAPIErrorDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -2021006695807894437L;
    private Date timestamp;
    private Integer status;
    private String exception;
    private String message;
    private String path;
    private String error;
}
