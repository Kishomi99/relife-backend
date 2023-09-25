package com.Employee.RegisterLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Employee.RegisterLogin.model.User;
import com.Employee.RegisterLogin.DTO.cart.AddToCartDto;
import com.Employee.RegisterLogin.DTO.cart.CartDto;
import com.Employee.RegisterLogin.common.ApiResponse;
import com.Employee.RegisterLogin.model.Product;
import com.Employee.RegisterLogin.service.AuthenticationService;
import com.Employee.RegisterLogin.service.CartService;
import com.Employee.RegisterLogin.service.ProductService;

import exceptions.AuthenticationFailException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/cart")
public class CartController {
	 @Autowired
	 CartService cartService;

	 @Autowired
	 ProductService productService;

	 @Autowired
	 AuthenticationService authenticationService;
	
	@PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token)
             {
        // first authenticate the token
        try {
			authenticationService.authenticate(token);
		} catch (AuthenticationFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // get the user
        User user = authenticationService.getUser(token);

        // find the product to add and add item by service
     
        cartService.addToCart(addToCartDto, user);

        // return response
        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
	 @GetMapping("/")
	    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token) {
	        // authenticate the token
	        try {
				authenticationService.authenticate(token);
			} catch (AuthenticationFailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // find the user
	        User user = authenticationService.getUser(token);

	        // get cart items

	        CartDto cartDto = cartService.listCartItems(user);
	        return new ResponseEntity<>(cartDto, HttpStatus.OK);
	    }
	  @DeleteMapping("/delete/{cartItemId}")
	    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Integer itemId,
	                                                      @RequestParam("token") String token) {

	        // authenticate the token
	        try {
				authenticationService.authenticate(token);
			} catch (AuthenticationFailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // find the user
	        User user = authenticationService.getUser(token);

	        cartService.deleteCartItem(itemId, user);

	        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);

	    }
}
