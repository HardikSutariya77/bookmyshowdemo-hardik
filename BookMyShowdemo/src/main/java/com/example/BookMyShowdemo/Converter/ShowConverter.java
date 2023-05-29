package com.example.BookMyShowdemo.Converter;

import com.example.BookMyShowdemo.Model.Show;
import com.example.BookMyShowdemo.dto.requestDto.Showdto;
import com.example.BookMyShowdemo.dto.responseDto.ShowResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static Show dtoToEntity(Showdto showdto){
        return Show.builder().show_date(showdto.getShowdate()).show_time(showdto.getShowtime()).build();
    }

    public static ShowResponseDto entityToDto(Show show,Showdto showdto) {
       return ShowResponseDto.builder().id(show.getId()).showdate(show.getShow_date()).showtime(showdto.getShowtime()).movieResponseDto(showdto.getMovieResponseDto()).theaterResponseDto(showdto.getTheaterResponseDto()).build();
    }

    public static ShowResponseDto entityToDto(Show show){
        return ShowResponseDto.builder().id(show.getId()).showtime(show.getShow_time()).showdate(show.getShow_date()).build();
    }
}
