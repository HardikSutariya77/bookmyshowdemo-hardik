package com.example.BookMyShowdemo.Service;

import com.example.BookMyShowdemo.dto.requestDto.Moviedto;
import com.example.BookMyShowdemo.dto.responseDto.MovieResponseDto;

public interface MovieService {

    public MovieResponseDto addMovie(Moviedto moviedto);

    public MovieResponseDto getMovie(int id);

    public void deleteMovie(int id);
}
