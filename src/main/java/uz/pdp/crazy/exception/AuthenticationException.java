package uz.pdp.crazy.exception;


public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("Incorrect phone number or password");
    }
}

