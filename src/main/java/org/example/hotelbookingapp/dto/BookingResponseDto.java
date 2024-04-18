package org.example.hotelbookingapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BookingResponseDto(
        Long id,
        String username,
        Long roomId,
        LocalDateTime bookingDate,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal price
) {
}
