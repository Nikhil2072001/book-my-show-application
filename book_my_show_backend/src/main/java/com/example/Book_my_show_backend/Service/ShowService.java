package com.example.Book_my_show_backend.Service;

import com.example.Book_my_show_backend.Dtos.ShowRequestDto;
import com.example.Book_my_show_backend.Models.*;
import com.example.Book_my_show_backend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(ShowRequestDto showRequestDto){
        try{
            ShowEntity show = ShowEntity.builder().showDate(showRequestDto.getShowDate())
                    .showTime(showRequestDto.getShowTime()).multiplier(showRequestDto.getMultiplier()).build();
            MovieEntity movie = movieRepository.findBymovieName(showRequestDto.getMovieName());
            show.setMovie(movie);
            TheaterEntity theater = theaterRepository.findById(showRequestDto.getTheaterId()).get();
            show.setTheater(theater);

            List<ShowSeatEntity> showSeatEntityList = createShowSeats(theater.getTheaterSeatEntityList());
            show.setListOfSeats(showSeatEntityList);
            for(ShowSeatEntity showSeat: showSeatEntityList){
                showSeat.setShow(show);
            }
            showRepository.save(show);
            return "show successfully added";

        }
        catch(Exception e){
            return "Something went wrong while adding show";
        }

    }
    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntityList){
        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();
        for(TheaterSeatEntity theaterSeat: theaterSeatEntityList){
            ShowSeatEntity showSeatEntity = ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType()).build();
            showSeatEntityList.add(showSeatEntity);
        }
        showSeatRepository.saveAll(showSeatEntityList);
        return showSeatEntityList;
    }
}
