package com.simendi.interview.zimttech.exception;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public class EndPointException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3606509494328908116L;

    public EndPointException(String message) {
        super(message);
    }

    public EndPointException(String message, Throwable cause) {
        super(message, cause);
    }
}
