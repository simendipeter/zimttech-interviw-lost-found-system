package com.simendi.interview.zimttech.endpoint;

import com.simendi.interview.zimttech.exception.EndPointException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static com.simendi.interview.zimttech.statval.Constants.Path.DASHBOARD;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
@RequestMapping(DASHBOARD)
public interface DashboardEndPoint {

    ResponseEntity display(Principal p_Principal) throws EndPointException;
}
