package com.example.Book_my_show_backend.Controller;


import com.example.Book_my_show_backend.Dtos.BookTicketRequestDto;
import com.example.Book_my_show_backend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto){
        String s="";
        try {
            s=ticketService.bookTicket(bookTicketRequestDto);
            return s;
        }
        catch (Exception e){
            return s;
        }
    }
    @DeleteMapping("/cancel_booking")
    public String cancelBooking(@RequestParam("id") int id){
       return ticketService.cancelBooking(id);
    }
}
