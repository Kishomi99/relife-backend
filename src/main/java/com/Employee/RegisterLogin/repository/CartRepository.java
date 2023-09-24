package com.Employee.RegisterLogin.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Employee.RegisterLogin.model.Cart;
import com.Employee.RegisterLogin.model.User;
import com.Employee.RegisterLogin.service.CartService;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
	

	 List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
