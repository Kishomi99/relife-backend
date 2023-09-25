package com.Employee.RegisterLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.RegisterLogin.model.AuthenticationToken;
import com.Employee.RegisterLogin.model.User;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	AuthenticationToken findByUser(User user);
	   AuthenticationToken findTokenByToken(String token);
}
