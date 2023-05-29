package com.example.BookMyShowdemo.dto.requestDto;

import com.example.BookMyShowdemo.dto.responseDto.MovieResponseDto;
import com.example.BookMyShowdemo.dto.responseDto.TheaterResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@Getter
@Setter
public class Showdto {
    private LocalDate showdate;
    private LocalTime showtime;
    MovieResponseDto movieResponseDto;
    TheaterResponseDto theaterResponseDto;
}
