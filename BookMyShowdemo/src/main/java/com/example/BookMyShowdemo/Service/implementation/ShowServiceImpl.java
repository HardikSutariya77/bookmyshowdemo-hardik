package com.example.BookMyShowdemo.Service.implementation;

import com.example.BookMyShowdemo.Converter.ShowConverter;
import com.example.BookMyShowdemo.Model.*;
import com.example.BookMyShowdemo.Repository.MovieRepository;
import com.example.BookMyShowdemo.Repository.ShowRepository;
import com.example.BookMyShowdemo.Repository.ShowSeatRepository;
import com.example.BookMyShowdemo.Repository.TheaterRepository;
import com.example.BookMyShowdemo.Service.ShowService;
import com.example.BookMyShowdemo.dto.requestDto.Showdto;
import com.example.BookMyShowdemo.dto.responseDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;

    @Override
    public ShowResponseDto addShow(Showdto showdto) {
        Show show= ShowConverter.dtoToEntity(showdto);
        Movie movie=movieRepository.findById(showdto.getMovieResponseDto().getId()).get();
        Theater theater=theaterRepository.findById(showdto.getTheaterResponseDto().getId()).get();
        show.setMovie(movie);
        show.setTheater(theater);
        showRepository.save(show);
        List<ShowSeat> showSeats=createShowSeats(theater.getTheaterSeats(),show);
        showSeatRepository.saveAll(showSeats);
        ShowResponseDto showResponseDto=ShowConverter.entityToDto(show,showdto);
        return showResponseDto;
    }

    private List<ShowSeat> createShowSeats(List<TheaterSeat> theaterSeats, Show show) {
        List<ShowSeat> showSeats=new ArrayList<>();
        for(TheaterSeat theaterseat:theaterSeats){
            ShowSeat seats=ShowSeat.builder().seatNo(theaterseat.getSeat()).rate(theaterseat.getRate()).seatType(theaterseat.getType()).build();
            showSeats.add(seats);
        }
        for(ShowSeat seats:showSeats){
            seats.setShow(show);
        }
        show.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        Show show=showRepository.findById(id).get();
        return ShowConverter.entityToDto(show);
    }
}
