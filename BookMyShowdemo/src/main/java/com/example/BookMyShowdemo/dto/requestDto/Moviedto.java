package com.example.BookMyShowdemo.dto.requestDto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Moviedto {
    private String name;
    private LocalDate realease_date;
}
