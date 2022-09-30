package com.simendi.interview.zimttech.exception;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public class ServiceException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3882661372718700763L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
