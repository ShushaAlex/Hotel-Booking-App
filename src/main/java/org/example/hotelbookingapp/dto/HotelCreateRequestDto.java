package org.example.hotelbookingapp.dto;

import jakarta.validation.constraints.NotBlank;

public record HotelCreateRequestDto(

        @NotBlank
        String title,
        String country,
        String city,
        String street,
        String house,
        Integer index,
        Byte starsCount
) {
}
