package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.HotelCreateRequestDto;
import org.example.hotelbookingapp.dto.HotelResponseDto;
import org.example.hotelbookingapp.entity.Address;
import org.example.hotelbookingapp.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public Hotel toHotel(HotelCreateRequestDto dto) {
        return Hotel.builder()
                .title(dto.title())
                .address(new Address(dto.country(), dto.city(), dto.street(), dto.house(), dto.index()))
                .starsCount(dto.starsCount())
                .build();
    }

    public HotelResponseDto toHotelResponseDto(Hotel hotel) {
        return new HotelResponseDto(
                hotel.getId(),
                hotel.getTitle(),
                hotel.getAddress().getCity(),
                hotel.getStarsCount());
    }

}
