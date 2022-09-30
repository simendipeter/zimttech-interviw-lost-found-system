package com.simendi.interview.zimttech.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@Getter
@Setter
public class RequestLostItemDTO implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3198880434676247053L;
    private String description;
    private String province;
    private Date date;
}
