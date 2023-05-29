package com.example.BookMyShowdemo.dto.responseDto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@ToString
public class ShowResponseDto {
    private int id;
    private LocalDate showdate;
    private LocalTime showtime;
    MovieResponseDto movieResponseDto;
    TheaterResponseDto theaterResponseDto;
}
