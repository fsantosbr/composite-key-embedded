package br.com.fsantosinfo.compositekeyembedded.exception;

public class ErrorGameBasicException extends RuntimeException {
    
    private static final long serialVersionUID = 2L;

    public ErrorGameBasicException(String message) {       
        super(message);
    }
}
