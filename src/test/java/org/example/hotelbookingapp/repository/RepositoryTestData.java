package org.example.hotelbookingapp.repository;

import org.example.hotelbookingapp.entity.Address;
import org.example.hotelbookingapp.entity.Booking;
import org.example.hotelbookingapp.entity.Hotel;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class RepositoryTestData {
    public static LocalDateTime DATE_TIME = LocalDateTime.now();
    public static LocalDate START_DATE = LocalDate.of(2024, 5, 1);
    public static LocalDate END_DATE = LocalDate.of(2024, 5, 5);

    public static final Address ADDRESS = new Address("Country1", "City1", "Street1", "House1", 23345);

    public static final User USER = createUser();

    public static final Hotel HOTEL = createHotel();

    public static final Room ROOM = createRoom();

    public static final Booking BOOKING = createBooking();

    private static Booking createBooking() {
        Booking booking = Booking.builder()
                .room(null)
                .bookingDate(DATE_TIME)
                .startDate(START_DATE)
                .endDate(START_DATE)
                .user(null)
                .build();

        return booking;
    }

    private static Hotel createHotel() {
        Hotel hotel = Hotel.builder()
                .title("test1")
                .address(ADDRESS)
                .starsCount(1)
                .build();
        return hotel;
    }

    private static Room createRoom() {
        Room room = Room.builder()
                .hotel(HOTEL)
                .bedCount((byte) 1)
                .isPetFriendly(true)
                .price(BigDecimal.valueOf(1.0))
                .build();

        HOTEL.addRoom(room);
        return room;
    }

    private static User createUser() {
        User user = User.builder()
                .username("testName")
                .email("testEmail")
                .build();
        return user;
    }
}
