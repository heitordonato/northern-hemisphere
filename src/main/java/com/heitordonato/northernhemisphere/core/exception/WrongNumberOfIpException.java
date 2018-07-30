package com.heitordonato.northernhemisphere.core.exception;

/**
 * @author Heitor Donato
 *
 */
public class WrongNumberOfIpException extends RuntimeException {

    public WrongNumberOfIpException() {
    }

    public WrongNumberOfIpException(String message) {
        super(message);
    }

    public WrongNumberOfIpException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongNumberOfIpException(Throwable cause) {
        super(cause);
    }

    public WrongNumberOfIpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}