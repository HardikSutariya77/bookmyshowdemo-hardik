package com.example.BookMyShowdemo.Converter;

import com.example.BookMyShowdemo.Model.Theater;
import com.example.BookMyShowdemo.dto.requestDto.Theaterdto;
import com.example.BookMyShowdemo.dto.responseDto.TheaterResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {

    public static Theater dtoToEntity(Theaterdto theaterdto){
        return Theater.builder().name(theaterdto.getName()).address(theaterdto.getAddress()).city(theaterdto.getCity()).theaterType(theaterdto.getTheatreType()).build();
    }

    public static TheaterResponseDto entityToDto(Theater theater){
        return TheaterResponseDto.builder().address(theater.getAddress()).name(theater.getName()).city(theater.getCity()).id(theater.getId()).theatreType(theater.getTheaterType()).build();
    }
}
