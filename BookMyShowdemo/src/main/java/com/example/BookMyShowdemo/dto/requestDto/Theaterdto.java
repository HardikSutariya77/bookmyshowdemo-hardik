package com.example.BookMyShowdemo.dto.requestDto;

import com.example.BookMyShowdemo.Model.Theater;
import com.example.BookMyShowdemo.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Theaterdto {
    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;
}
