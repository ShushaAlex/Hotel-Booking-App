package org.example.hotelbookingapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelbookingapp.dto.HotelCreateRequestDto;
import org.example.hotelbookingapp.dto.HotelResponseDto;
import org.example.hotelbookingapp.service.HotelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public HotelResponseDto saveHotel(@RequestBody HotelCreateRequestDto hotel) {
        return hotelService.saveHotel(hotel);
    }
}
