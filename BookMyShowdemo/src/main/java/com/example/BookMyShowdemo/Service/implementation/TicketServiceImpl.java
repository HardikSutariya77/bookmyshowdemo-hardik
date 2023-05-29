package com.example.BookMyShowdemo.Service.implementation;

import com.example.BookMyShowdemo.Converter.TicketConverter;
import com.example.BookMyShowdemo.Model.Show;
import com.example.BookMyShowdemo.Model.ShowSeat;
import com.example.BookMyShowdemo.Model.Ticket;
import com.example.BookMyShowdemo.Model.User;
import com.example.BookMyShowdemo.Repository.ShowRepository;
import com.example.BookMyShowdemo.Repository.TicketRepository;
import com.example.BookMyShowdemo.Repository.UserRepository;
import com.example.BookMyShowdemo.Service.TicketService;
import com.example.BookMyShowdemo.dto.requestDto.BookTicketRequestDto;
import com.example.BookMyShowdemo.dto.responseDto.TicketResponseDto;
import com.example.BookMyShowdemo.dto.responseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        User user=userRepository.findById(bookTicketRequestDto.getUserId()).get();
        Show show=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();
        List<ShowSeat> showSeats=show.getShowSeats();
        List<ShowSeat> bookedSeats=new ArrayList<>();
        for(ShowSeat seats:showSeats){
            if(!seats.isBooked() && seats.getSeatType().equals(bookTicketRequestDto.getSeatType()) && requestedSeats.contains(seats.getSeatNo())){
                bookedSeats.add(seats);
            }
        }

        int amount=0;
        if(bookedSeats.size()!=requestedSeats.size()) throw new Error("All seats are not available");
        Ticket ticket=Ticket.builder().user(user).show(show).showSeats(bookedSeats).build();

        for(ShowSeat seats:bookedSeats)
        {
            seats.setBooked(true);
            seats.setBookedDate(new Date());
            seats.setTicket(ticket);
            amount+= seats.getRate();
            System.out.println(bookedSeats.toString());
        }

        ticket.setAllottedSeat(listOfSeatsToString(bookedSeats));
        ticket.setAmount(amount);
        show.getTickets().add(ticket);
        user.getTickets().add(ticket);
        ticketRepository.save(ticket);
        return TicketConverter.entityToDto(ticket);
    }

    private String listOfSeatsToString(List<ShowSeat> bookedSeats) {
        String s="";
        for(ShowSeat seats:bookedSeats){
            s=s+seats.getSeatNo()+" ";
        }
        return s;
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        Ticket ticket=ticketRepository.findById(id).get();
        return TicketConverter.entityToDto(ticket);
    }
}
