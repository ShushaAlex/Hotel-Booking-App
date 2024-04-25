package org.example.hotelbookingapp.dto.hotel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record HotelCreateRequestDto(

        @NotBlank
        String title,
        @NotBlank
        String country,
        @NotBlank
        String city,
        @NotBlank
        String street,
        @NotBlank
        String house,
        Integer index,
        @Size(min = 1, max = 5)
        Byte starsCount
) {
}
