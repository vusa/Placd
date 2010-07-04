package za.co.placd.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author vusa
 */
@Service("authProvider")
public class MyAuthProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    AuthServiceImpl asi;

    @Override
    protected void additionalAuthenticationChecks(UserDetails ud, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken upat) throws AuthenticationException {
        if (asi.authenticate(username, upat.getCredentials().toString())) {
            return asi.getUserDetails();
        } else {
            throw new BadCredentialsException("User could not be verified");
        }
    }
}
