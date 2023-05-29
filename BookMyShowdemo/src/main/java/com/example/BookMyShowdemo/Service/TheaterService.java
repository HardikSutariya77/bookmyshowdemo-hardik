package com.example.BookMyShowdemo.Service;

import com.example.BookMyShowdemo.dto.requestDto.Theaterdto;
import com.example.BookMyShowdemo.dto.responseDto.TheaterResponseDto;

public interface TheaterService {

    public TheaterResponseDto addTheatre(Theaterdto theatredto);

    public TheaterResponseDto getTheatre(int id);
}
