package net.dontdrinkandroot.example.angularrestspringsecurity.filters;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    
    private static Log logger = LogFactory.getLog(AuthenticationProvider.class);
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
 
        // Assume that if principal present user was authenticated against external service
        if (authentication != null && authentication.getPrincipal() != null) {
            authentication.setAuthenticated(true);
            if (logger.isDebugEnabled()) {
                logger.debug("User " + authentication.getPrincipal() + " authenticated");
            }
            return authentication;
        }
 
        if (logger.isDebugEnabled()) {
            logger.debug("Ticked not valid");
        }
 
        throw new BadCredentialsException("Ticked not valid");
    }
 
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}