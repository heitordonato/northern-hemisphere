package com.heitordonato.northernhemisphere.core.exception;

/**
 * @author Heitor Donato
 *
 */
public class IpNotFoundException extends RuntimeException {

    public IpNotFoundException() {
    }

    public IpNotFoundException(String message) {
        super(message);
    }

    public IpNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IpNotFoundException(Throwable cause) {
        super(cause);
    }

    public IpNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}