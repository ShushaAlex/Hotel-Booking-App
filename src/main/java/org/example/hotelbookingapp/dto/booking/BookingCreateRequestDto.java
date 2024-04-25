package org.example.hotelbookingapp.dto.booking;

import java.time.LocalDate;

public record BookingCreateRequestDto(
        String username,
        Long roomId,
        LocalDate startDate,
        LocalDate endDate
) {
}
