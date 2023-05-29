package com.example.BookMyShowdemo.Service;

import com.example.BookMyShowdemo.dto.requestDto.BookTicketRequestDto;
import com.example.BookMyShowdemo.dto.responseDto.TicketResponseDto;

public interface TicketService {

    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    public TicketResponseDto getTicket(int id);
}
