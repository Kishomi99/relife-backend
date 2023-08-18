package com.Employee.RegisterLogin.service;

import com.Employee.RegisterLogin.DTO.UserDTO;
import com.Employee.RegisterLogin.DTO.LoginDTO;
import com.Employee.RegisterLogin.response.LoginResponse;

public interface UserService {

    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);


}
