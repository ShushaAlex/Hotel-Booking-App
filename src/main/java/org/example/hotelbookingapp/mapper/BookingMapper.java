package org.example.hotelbookingapp.mapper;

import org.example.hotelbookingapp.dto.BookingResponseDto;
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
}
