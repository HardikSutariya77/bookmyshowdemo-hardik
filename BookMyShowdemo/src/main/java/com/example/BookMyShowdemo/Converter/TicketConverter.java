package com.example.BookMyShowdemo.Converter;

import com.example.BookMyShowdemo.Model.Ticket;
import com.example.BookMyShowdemo.dto.responseDto.TicketResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketResponseDto entityToDto(Ticket ticket){
        return TicketResponseDto.builder().id(ticket.getId()).allotedSeat(ticket.getAllottedSeat()).amount(ticket.getAmount()).build();
    }
}
