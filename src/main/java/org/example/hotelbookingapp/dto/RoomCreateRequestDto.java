package org.example.hotelbookingapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record RoomCreateRequestDto(
        @Positive
        Long hotelId,

        @Min(1)
        Byte bedCount,

        boolean isPetFriendly,

        @Positive
        BigDecimal price) {

}