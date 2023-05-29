package com.example.BookMyShowdemo.Service.implementation;

import com.example.BookMyShowdemo.Converter.MovieConverter;
import com.example.BookMyShowdemo.Model.Movie;
import com.example.BookMyShowdemo.Repository.MovieRepository;
import com.example.BookMyShowdemo.Service.MovieService;
import com.example.BookMyShowdemo.dto.requestDto.Moviedto;
import com.example.BookMyShowdemo.dto.responseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    MovieResponseDto movieResponseDto;
    @Override
    public MovieResponseDto addMovie(Moviedto moviedto) {
        if(movieRepository.existsByName(moviedto.getName())){
            MovieResponseDto.builder().name("Movie already exists");
            return movieResponseDto;
        }

        Movie movie= MovieConverter.dtoToEntity(moviedto);
        movie=movieRepository.save(movie);
        movieResponseDto=MovieConverter.entityToDto(movie);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        Movie movie=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.entityToDto(movie);
        return movieResponseDto;
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
