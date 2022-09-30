package com.simendi.interview.zimttech.endpoint.impl;

import com.simendi.interview.zimttech.dto.ResponseData;
import com.simendi.interview.zimttech.endpoint.DashboardEndPoint;
import com.simendi.interview.zimttech.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created on 5/9/19.
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@RestController
public class DashboardEndPointException implements DashboardEndPoint {
    @Override
    public ResponseEntity display(Principal p_Principal) throws EndPointException {
        return ResponseEntity.ok(new ResponseData("200", p_Principal.getName()));
    }
}
