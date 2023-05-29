package com.example.BookMyShowdemo.dto.responseDto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releasedate;
}
