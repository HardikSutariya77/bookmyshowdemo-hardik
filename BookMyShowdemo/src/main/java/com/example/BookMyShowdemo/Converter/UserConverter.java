package com.example.BookMyShowdemo.Converter;

import com.example.BookMyShowdemo.Model.User;
import com.example.BookMyShowdemo.dto.requestDto.UserDto;
import com.example.BookMyShowdemo.dto.responseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static User dtoToEntity(UserDto userDto){
        return User.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
    }

    public static UserResponseDto entityToDto(User user){
        return UserResponseDto.builder().name(user.getName()).mobile(user.getMobile()).id(user.getId()).build();
    }
}
