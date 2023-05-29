package com.example.BookMyShowdemo.dto.requestDto;

import com.example.BookMyShowdemo.enums.SeatType;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class BookTicketRequestDto {
    private int userId;
    private int showId;
    private SeatType seatType;
    private Set<String> requestedSeats;
}
