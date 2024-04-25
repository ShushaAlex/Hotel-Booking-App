package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapp.dto.booking.BookingResponseDto;
import org.example.hotelbookingapp.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingResponseDto bookingResponseDto(Booking booking) {
        return new BookingResponseDto(
                booking.getId(),
                booking.getUser().getUsername(),
                booking.getRoom().getId(),
                booking.getBookingDate(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getPrice()
        );
    }

    public Booking toBooking(BookingCreateRequestDto dto) {
        return Booking.builder()
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .build();
    }
}
