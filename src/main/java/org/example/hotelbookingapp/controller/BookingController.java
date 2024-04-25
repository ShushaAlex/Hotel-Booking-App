package org.example.hotelbookingapp.controller;

import org.example.hotelbookingapp.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapp.dto.booking.BookingResponseDto;
import org.example.hotelbookingapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingResponseDto> findAll() {
        return bookingService.findAll();
    }

    @PostMapping
    public BookingResponseDto saveBooking(@RequestBody BookingCreateRequestDto dto) {
        return bookingService.saveBooking(dto);
    }

    @PostMapping("/{id}")
    public HttpStatus deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);

        return HttpStatus.resolve(200);
    }
}
