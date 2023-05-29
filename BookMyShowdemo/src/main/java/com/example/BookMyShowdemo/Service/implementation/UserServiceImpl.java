package com.example.BookMyShowdemo.Service.implementation;

import com.example.BookMyShowdemo.Converter.UserConverter;
import com.example.BookMyShowdemo.Model.User;
import com.example.BookMyShowdemo.Repository.UserRepository;
import com.example.BookMyShowdemo.Service.UserService;
import com.example.BookMyShowdemo.dto.requestDto.UserDto;
import com.example.BookMyShowdemo.dto.responseDto.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserDto userdto) {
        User u= UserConverter.dtoToEntity(userdto);
        userRepository.save(u);

    }

    @Override
    public UserResponseDto getUser(int id) {
        User u=userRepository.findById(id).get();
        return UserConverter.entityToDto(u);
    }
}
