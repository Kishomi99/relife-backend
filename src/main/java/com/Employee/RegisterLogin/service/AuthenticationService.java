package com.Employee.RegisterLogin.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.RegisterLogin.model.AuthenticationToken;
import com.Employee.RegisterLogin.model.User;
import com.Employee.RegisterLogin.repository.TokenRepository;

import exceptions.AuthenticationFailException;

@Service
public class AuthenticationService {

	   @Autowired
	   TokenRepository tokenRepository;
	
	public void saveConfirmationToken(AuthenticationToken authenticationToken) {
		// TODO Auto-generated method stub
		 tokenRepository.save(authenticationToken);
	}

	public AuthenticationToken getToken(User user) {
		// TODO Auto-generated method stub
		return tokenRepository.findByUser(user);
	}
	   // get User from the token
    public User getUser(String token) {
       final AuthenticationToken authenticationToken = tokenRepository.findTokenByToken(token);
        if (Objects.nonNull(authenticationToken)) {
            if (Objects.nonNull(authenticationToken.getUser())) {
                return authenticationToken.getUser();
            }
        }
        return null;
    }
	  // check if the token is valid
    public void authenticate(String token) throws AuthenticationFailException {
        if (!Objects.nonNull(token)) {
            throw new AuthenticationFailException("token not present");
        }
        if (!Objects.nonNull(getUser(token))) {
            throw new AuthenticationFailException("token not valid");
        }
    }

}
