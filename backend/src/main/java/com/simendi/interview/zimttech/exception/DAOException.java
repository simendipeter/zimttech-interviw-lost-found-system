package com.simendi.interview.zimttech.exception;

/**
 * Created on 30/09/2022
 *
 * @author <a href="mailto:simendipeter@gmail.com">Simendi Peter</a>
 */
public class DAOException extends Exception {
    /**
     *
     *
     */
    private static final long serialVersionUID = 2682641418110879822L;

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
