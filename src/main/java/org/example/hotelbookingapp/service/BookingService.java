package org.example.hotelbookingapp.service;

import org.example.hotelbookingapp.dto.booking.BookingCreateRequestDto;
import org.example.hotelbookingapp.dto.booking.BookingResponseDto;
import org.example.hotelbookingapp.entity.Booking;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.entity.User;
import org.example.hotelbookingapp.exception.BookingException;
import org.example.hotelbookingapp.exception.RoomException;
import org.example.hotelbookingapp.exception.UserException;
import org.example.hotelbookingapp.mapper.BookingMapper;
import org.example.hotelbookingapp.repository.BookingRepository;
import org.example.hotelbookingapp.repository.RoomRepository;
import org.example.hotelbookingapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, RoomRepository roomRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.bookingMapper = bookingMapper;
    }

    @Transactional
    public BookingResponseDto saveBooking(BookingCreateRequestDto dto) {
        Room room = roomRepository.findById(dto.roomId()).orElseThrow(() -> new RoomException("no such room"));
        int daysCount = dto.endDate().compareTo(dto.startDate());

        User user = userRepository.findByUsername(dto.username()).orElseThrow(() -> new UserException("no such user"));

        Booking booking = bookingMapper.toBooking(dto);
        booking.setUser(user);
        booking.setBookingDate(LocalDateTime.now());
        booking.setRoom(room);
        booking.setPrice(new BigDecimal(daysCount * (room.getPrice()).doubleValue()));

        room.addBooking(booking);
        user.addBooking(booking);

        return bookingMapper.bookingResponseDto(bookingRepository.save(booking));
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingException("no such booking"));
        User user = userRepository.findById(booking.getUser().getId()).orElseThrow(() -> new UserException("no such user"));
        Room room = roomRepository.findById(booking.getRoom().getId()).orElseThrow(() -> new RoomException("no such room"));

        user.removeBooking(booking);
        room.removeBooking(booking);

        bookingRepository.delete(booking);
    }

    public List<BookingResponseDto> findAll() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::bookingResponseDto)
                .toList();
    }
}
