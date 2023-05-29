package com.example.BookMyShowdemo.dto.responseDto;

import com.example.BookMyShowdemo.enums.TheatreType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TheaterResponseDto {
    private int id;
    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;
}
