package com.example.BookMyShowdemo.Service;

import com.example.BookMyShowdemo.dto.requestDto.Showdto;
import com.example.BookMyShowdemo.dto.responseDto.ShowResponseDto;

public interface ShowService {
    public ShowResponseDto addShow(Showdto showdto);

    public ShowResponseDto getShow(int id);
}
