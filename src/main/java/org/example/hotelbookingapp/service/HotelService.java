package org.example.hotelbookingapp.service;

import org.example.hotelbookingapp.dto.hotel.HotelCreateRequestDto;
import org.example.hotelbookingapp.dto.hotel.HotelResponseDto;
import org.example.hotelbookingapp.entity.Hotel;
import org.example.hotelbookingapp.mapper.HotelMapper;
import org.example.hotelbookingapp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    @Autowired
    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Transactional
    public HotelResponseDto saveHotel(HotelCreateRequestDto hotelCreateRequestDto) {
        Hotel hotel = hotelMapper.toHotel(hotelCreateRequestDto);

        return hotelMapper.toHotelResponseDto(hotelRepository.save(hotel));
    }
}
