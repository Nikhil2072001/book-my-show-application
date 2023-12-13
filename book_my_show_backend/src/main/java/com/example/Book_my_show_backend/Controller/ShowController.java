package com.example.Book_my_show_backend.Controller;

import com.example.Book_my_show_backend.Dtos.ShowRequestDto;
import com.example.Book_my_show_backend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add_show")
    public ResponseEntity<String> addShow(@RequestBody()ShowRequestDto showRequestDto){
        String s = showService.addShow(showRequestDto);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }
}
