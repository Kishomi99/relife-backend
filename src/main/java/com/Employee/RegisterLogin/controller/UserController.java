package com.Employee.RegisterLogin.controller;

import com.Employee.RegisterLogin.DTO.UserDTO;
import com.Employee.RegisterLogin.DTO.LoginDTO;
import com.Employee.RegisterLogin.response.LoginResponse;
import com.Employee.RegisterLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path="/save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id= userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }



}
