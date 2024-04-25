package org.example.hotelbookingapp.dto.hotel;

public record HotelResponseDto(
        Long id,
        String title,
        String city,
        Integer starsCount
) {
}
