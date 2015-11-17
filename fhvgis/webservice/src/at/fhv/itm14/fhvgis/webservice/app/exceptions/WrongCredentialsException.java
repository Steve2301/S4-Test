package at.fhv.itm14.fhvgis.webservice.app.exceptions;

/**
 * Author: Philip Heimböck
 * Date: 06.11.15.
 */
public class WrongCredentialsException extends Exception {
    public WrongCredentialsException() {
    }

    public WrongCredentialsException(String message) {
        super(message);
    }

    public WrongCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongCredentialsException(Throwable cause) {
        super(cause);
    }

    public WrongCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
