package com.example.BookMyShowdemo.Controller;

import com.example.BookMyShowdemo.Service.implementation.TicketServiceImpl;
import com.example.BookMyShowdemo.dto.requestDto.BookTicketRequestDto;
import com.example.BookMyShowdemo.dto.responseDto.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketResponseDto bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("/get/{id}")
    public TicketResponseDto getTicket(@PathVariable int id){
        return ticketService.getTicket(id);
    }
}
