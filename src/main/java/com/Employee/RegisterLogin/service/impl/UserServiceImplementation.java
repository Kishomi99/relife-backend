package com.Employee.RegisterLogin.service.impl;

import com.Employee.RegisterLogin.DTO.UserDTO;
import com.Employee.RegisterLogin.DTO.LoginDTO;
import com.Employee.RegisterLogin.model.User;
import com.Employee.RegisterLogin.repository.UserRepository;
import com.Employee.RegisterLogin.response.LoginResponse;
import com.Employee.RegisterLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO)
    {
        User user = new User(
                userDTO.getUserid(),
                userDTO.getFullname(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())// we want set the aschi password

        );
        userRepository.save(user);
        return user.getFullname();
    }
    UserDTO userDTO;



    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {

                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }


    }


}
