package org.example.hotelbookingapp.dto;

public record HotelResponseDto(
        Long id,
        String title,
        String city,
        Byte starsCount
) {
}
