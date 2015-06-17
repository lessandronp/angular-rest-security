package net.dontdrinkandroot.example.angularrestspringsecurity.exceptions;

import java.io.IOException;

import net.dontdrinkandroot.example.angularrestspringsecurity.util.MessageUtil;

/**
 * Exceção de Dns inexistente.
 * @author Lessandro
 */
public class DnsMailException extends Exception {

    private static final long serialVersionUID = 1L;

    public DnsMailException() throws IOException {  
        super(MessageUtil.getMessage("msg.invalid.email", new Object()));  
    }

    public DnsMailException(String message) {  
        super(message);  
    }
}
