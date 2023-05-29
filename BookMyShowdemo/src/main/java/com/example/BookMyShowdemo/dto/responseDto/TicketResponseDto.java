package com.example.BookMyShowdemo.dto.responseDto;

import lombok.*;

@Data
@Builder
public class TicketResponseDto {
    private int id;
    private String allotedSeat;
    private int amount;
}
