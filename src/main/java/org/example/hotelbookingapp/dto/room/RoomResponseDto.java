package org.example.hotelbookingapp.dto.room;

import java.math.BigDecimal;

public record RoomResponseDto(
        Long id,
        String hotelName,
        Byte bedCount,
        boolean isPetFriendly,
        BigDecimal price
) {
}
