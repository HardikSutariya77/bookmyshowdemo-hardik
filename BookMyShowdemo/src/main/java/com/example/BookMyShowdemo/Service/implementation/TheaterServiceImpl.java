package com.example.BookMyShowdemo.Service.implementation;

import com.example.BookMyShowdemo.Converter.TheaterConverter;
import com.example.BookMyShowdemo.Model.Theater;
import com.example.BookMyShowdemo.Model.TheaterSeat;
import com.example.BookMyShowdemo.Repository.TheaterRepository;
import com.example.BookMyShowdemo.Repository.TheaterSeatRepository;
import com.example.BookMyShowdemo.Service.TheaterService;
import com.example.BookMyShowdemo.dto.requestDto.Theaterdto;
import com.example.BookMyShowdemo.dto.responseDto.TheaterResponseDto;
import com.example.BookMyShowdemo.enums.SeatType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Override
    public TheaterResponseDto addTheatre(Theaterdto theatredto) {
        Theater theater= TheaterConverter.dtoToEntity(theatredto);
        List<TheaterSeat> seats=createseats();
        theater.setTheaterSeats(seats);
        theater.setShows(null);
        for(TheaterSeat theaterSeat:seats){
            theaterSeat.setTheater(theater);
        }
        theaterRepository.save(theater);
        theaterSeatRepository.saveAll(seats);
        return TheaterConverter.entityToDto(theater);
    }

    private List<TheaterSeat> createseats() {
        List<TheaterSeat> seats=new ArrayList<>();

        seats.add(getTheaterseat("A1",200, SeatType.GOLD));
        seats.add(getTheaterseat("A2",200, SeatType.GOLD));
        seats.add(getTheaterseat("A3",200, SeatType.GOLD));
        seats.add(getTheaterseat("A4",200, SeatType.GOLD));
        seats.add(getTheaterseat("A5",200, SeatType.GOLD));

        seats.add(getTheaterseat("D1",150,SeatType.SILVER));
        seats.add(getTheaterseat("D2",150,SeatType.SILVER));
        seats.add(getTheaterseat("D3",150,SeatType.SILVER));
        seats.add(getTheaterseat("D4",150,SeatType.SILVER));
        seats.add(getTheaterseat("D5",150,SeatType.SILVER));

        seats.add(getTheaterseat("AA",250,SeatType.SOFA));
        seats.add(getTheaterseat("BB",250,SeatType.SOFA));
        seats.add(getTheaterseat("CC",250,SeatType.SOFA));
        seats.add(getTheaterseat("DD",250,SeatType.SOFA));
        seats.add(getTheaterseat("EE",250,SeatType.SOFA));

        return seats;

    }

    private TheaterSeat getTheaterseat(String seat,int rate, SeatType type){
        return TheaterSeat.builder().seat(seat).rate(rate).type(type).build();
    }

    @Override
    public TheaterResponseDto getTheatre(int id) {
        return TheaterConverter.entityToDto(theaterRepository.findById(id).get());

    }
}
