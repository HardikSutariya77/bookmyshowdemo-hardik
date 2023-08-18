package com.example.BookMyShowdemo.Controller;

import com.example.BookMyShowdemo.Service.implementation.UserServiceImpl;
import com.example.BookMyShowdemo.dto.requestDto.UserDto;
import com.example.BookMyShowdemo.dto.responseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUSer(@RequestBody(required = true) UserDto userdto){
        userService.addUser(userdto);
        return new ResponseEntity("User added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public UserResponseDto getUser(@RequestParam(required = true) int id ){

        return userService.getUser(id);
    }
}
