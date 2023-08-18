package com.example.BookMyShowdemo.Controller;

import com.example.BookMyShowdemo.Service.implementation.TheaterServiceImpl;
import com.example.BookMyShowdemo.dto.requestDto.Theaterdto;
import com.example.BookMyShowdemo.dto.responseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("/add")
    public TheaterResponseDto addTheater(@RequestBody(required = true) Theaterdto theaterdto){
        return theaterService.addTheatre(theaterdto);
    }

    @GetMapping("/get/{id}")
    public TheaterResponseDto getTheatre(@PathVariable(required = true) int id){
        return theaterService.getTheatre(id);
    }
}
