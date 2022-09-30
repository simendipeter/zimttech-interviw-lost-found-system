package com.simendi.interview.zimttech.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseData implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8524185686815426024L;
    private String responseCode;
    private String responseMsg;
}
