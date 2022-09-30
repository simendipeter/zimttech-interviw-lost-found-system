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
public class RequestLoginDTO implements Serializable{
    /**
     *
     *
     */
    private static final long serialVersionUID = -3717873746249151313L;

    private String userName;
    private String password;
}
