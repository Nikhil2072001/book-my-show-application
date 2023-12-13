package com.example.Book_my_show_backend.Service;

import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void  addMovie(MovieRequestDto movieRequestDto){
        MovieEntity movie = MovieEntity.builder().movieName(movieRequestDto.getMovieName())
                .duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getDate()).build();
        movieRepository.save(movie);
    }
    public MovieEntity getMovieByName(String name){
        return movieRepository.findBymovieName(name);
    }
}
