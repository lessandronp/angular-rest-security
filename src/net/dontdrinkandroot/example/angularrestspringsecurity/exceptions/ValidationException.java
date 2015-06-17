package net.dontdrinkandroot.example.angularrestspringsecurity.exceptions;

import java.io.IOException;

import net.dontdrinkandroot.example.angularrestspringsecurity.util.MessageUtil;

/**
 * Exceção de validação.
 * @author Lessandro
 */
public class ValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValidationException(String message) throws IOException {  
        super(MessageUtil.getMessage(message, new Object()));  
    }
}
