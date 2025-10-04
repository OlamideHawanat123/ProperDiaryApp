package africa.semicolon.controller;

import africa.semicolon.DTOs.requests.RegisterUserRequest;
import africa.semicolon.DTOs.responses.RegisterUserResponse;
import africa.semicolon.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserServices userService;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(RegisterUserRequest registerUserRequest){
        try{
            RegisterUserResponse response = userService.registerUser(registerUserRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(EmptyResultDataAccessException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
