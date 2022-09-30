package com.simendi.interview.zimttech.service;

import com.simendi.interview.zimttech.exception.ServiceException;
import com.simendi.interview.zimttech.model.User;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * Created on 5/17/18.
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public interface AuthenticationService extends LogoutHandler {

    User login(String p_UserName) throws ServiceException;

    void updateStatusLoggedIn(User p_User) throws ServiceException;

    void updateStatusLoggedOut(String p_UserName) throws ServiceException;

    void logoutJwt(HttpServletResponse httpServletResponse, String p_CookieName) throws ServiceException;
}
