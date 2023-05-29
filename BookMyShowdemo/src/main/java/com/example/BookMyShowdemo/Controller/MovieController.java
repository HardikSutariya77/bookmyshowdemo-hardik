package com.example.BookMyShowdemo.Controller;

import com.example.BookMyShowdemo.Service.implementation.MovieServiceImpl;
import com.example.BookMyShowdemo.dto.requestDto.Moviedto;
import com.example.BookMyShowdemo.dto.responseDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody Moviedto moviedto){
        MovieResponseDto movieResponseDto=movieService.addMovie(moviedto);
        return movieResponseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
        return new ResponseEntity("Movie successfully deleted", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public MovieResponseDto getMovie(@PathVariable int id){
        return  movieService.getMovie(id);
    }
}
