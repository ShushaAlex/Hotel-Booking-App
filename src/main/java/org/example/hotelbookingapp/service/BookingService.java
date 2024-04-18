package org.example.hotelbookingapp.service;

import org.example.hotelbookingapp.dto.BookingResponseDto;
import org.example.hotelbookingapp.mapper.BookingMapper;
import org.example.hotelbookingapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public Set<BookingResponseDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::bookingResponseDto)
                .collect(Collectors.toSet());
    }

}
