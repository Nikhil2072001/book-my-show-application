package com.example.Book_my_show_backend.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequestDto {

    LocalDate showDate;

    LocalTime showTime;

    String movieName;

    int theaterId;

    double multiplier;
}
