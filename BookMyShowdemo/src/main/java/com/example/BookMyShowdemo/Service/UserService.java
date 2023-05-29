package com.example.BookMyShowdemo.Service;

import com.example.BookMyShowdemo.dto.requestDto.UserDto;
import com.example.BookMyShowdemo.dto.responseDto.UserResponseDto;

public interface UserService {

    public void addUser(UserDto userdto);

    public UserResponseDto getUser(int id);
}
