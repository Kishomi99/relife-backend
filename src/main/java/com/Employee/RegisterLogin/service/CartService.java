package com.Employee.RegisterLogin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.RegisterLogin.DTO.cart.AddToCartDto;
import com.Employee.RegisterLogin.DTO.cart.CartDto;
import com.Employee.RegisterLogin.DTO.cart.CartItemDto;
import com.Employee.RegisterLogin.model.Cart;
import com.Employee.RegisterLogin.model.Product;
import com.Employee.RegisterLogin.model.User;
import com.Employee.RegisterLogin.repository.CartRepository;

import exceptions.CustomException;

@Service
public class CartService {
	 @Autowired
	 CartRepository cartRepository; 
	 
	 @Autowired
	 ProductService productService;

	    public void addToCart(AddToCartDto addToCartDto, User user) {
	    Product product=  productService.findById(addToCartDto.getProductId());
	    //    cartRepository.save(product);
	    	Cart cart= new Cart();
	    	cart.setProduct(product);
	    	cart.setUser(user);
	    	cart.setQuantity(addToCartDto.getQuantity());
	    	cart.setCreatedDate(new Date());
	    	
	    	cartRepository.save(cart);
	    
	    }

		public CartDto listCartItems(User user) {
	 List<Cart> cartList =	cartRepository.findAllByUserOrderByCreatedDateDesc(user);

	 		List<CartItemDto> cartItems = new ArrayList<>();
	 		double totalCost =0;
	 		for(Cart cart:cartList) {
	 			CartItemDto cartItemDto = new CartItemDto(cart);
	 			totalCost += cartItemDto.getQuantity()* cart.getProduct().getPrice();
	 			cartItems.add(cartItemDto);
	 		}
	 		CartDto cartDto = new CartDto();
	 		cartDto.setTotalCost(totalCost);
	 		cartDto.setCartItems(cartItems);
	 		return cartDto;
		}

		public void deleteCartItem(Integer cartItemId, User user) {
			  // the item id belongs to user

	        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

	        if (optionalCart.isEmpty()) {
	            throw new CustomException("cart item id is invalid: " + cartItemId);
	        }

	        Cart cart = optionalCart.get();

	        if (cart.getUser() != user) {
	            throw  new CustomException("cart item does not belong to user: " +cartItemId);
	        }

	        cartRepository.delete(cart);
			
		}
}
