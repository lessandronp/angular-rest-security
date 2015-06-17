package net.dontdrinkandroot.example.angularrestspringsecurity.exceptions;

import java.io.IOException;

import net.dontdrinkandroot.example.angularrestspringsecurity.util.MessageUtil;

public class UniqueKeyException extends Exception {

    private static final long serialVersionUID = 1L;
    private String msg; 

    public UniqueKeyException() throws IOException {  
        super(MessageUtil.getMessage("msg.invalid.email", new Object()));  
    }

    public UniqueKeyException(String message) {  
	super(message); 
	this.msg = message;
    }
    
    public UniqueKeyException(UniqueKeyException e1) {
	super(e1.getMessage()); 
    }

    @Override
    public String getMessage() {
        int initPos = this.msg.indexOf("Chave");
        if (initPos != -1) {
            String cutMessage = this.msg.substring(initPos, this.msg.length());
            cutMessage.replace("Chave", "");
            int endPos = cutMessage.indexOf("Error");
            String formattedMessage = cutMessage.substring(0, endPos).replace("(", " ")
            	.replace(")", " ").replace("=", " ");
            return formattedMessage;
        }
        return this.msg;
    }
}
