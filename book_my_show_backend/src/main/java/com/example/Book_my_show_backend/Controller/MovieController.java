package com.example.Book_my_show_backend.Controller;

import com.example.Book_my_show_backend.Dtos.MovieRequestDto;
import com.example.Book_my_show_backend.Models.MovieEntity;
import com.example.Book_my_show_backend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody()MovieRequestDto movieRequestDto){
        movieService.addMovie(movieRequestDto);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get_movieByName")
    public ResponseEntity<MovieEntity> getMovieByName(@RequestParam("movieName") String movieName){
        MovieEntity movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }
}
