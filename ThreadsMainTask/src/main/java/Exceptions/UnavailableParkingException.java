package Exceptions;

import java.security.SecureRandom;

public class UnavailableParkingException extends RuntimeException {

    public UnavailableParkingException() {
        super();
    }

    public UnavailableParkingException(String message, Throwable cause){
        super(message, cause);
    }

    public UnavailableParkingException(String message){
        super(message);
    }

    public UnavailableParkingException(Throwable cause){
        super(cause);
    }
}
