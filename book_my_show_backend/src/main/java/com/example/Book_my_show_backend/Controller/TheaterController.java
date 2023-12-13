package com.example.Book_my_show_backend.Controller;

import com.example.Book_my_show_backend.Dtos.TheaterRequestDto;
import com.example.Book_my_show_backend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody()TheaterRequestDto theaterRequestDto){
        theaterService.addTheater(theaterRequestDto);
        return new ResponseEntity<>("Added Successfully", HttpStatus.CREATED);
    }
    //Get theaters by theaterId

    //Get all theaters
}
