package com.example.BookMyShowdemo.Converter;

import com.example.BookMyShowdemo.Model.Movie;
import com.example.BookMyShowdemo.dto.requestDto.Moviedto;
import com.example.BookMyShowdemo.dto.responseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static Movie dtoToEntity(Moviedto moviedto){
        return Movie.builder().name(moviedto.getName()).releaseDate(moviedto.getRealease_date()).build();
    }

    public static MovieResponseDto entityToDto(Movie movie){
        return  MovieResponseDto.builder().name(movie.getName()).id(movie.getId()).releasedate(movie.getReleaseDate()).build();
    }
}
