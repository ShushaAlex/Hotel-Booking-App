package org.example.hotelbookingapp.repository;

import org.example.hotelbookingapp.entity.Booking;
import org.example.hotelbookingapp.entity.Hotel;
import org.example.hotelbookingapp.entity.Room;
import org.example.hotelbookingapp.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Collection;

import static org.example.hotelbookingapp.repository.RepositoryTestData.BOOKING;
import static org.example.hotelbookingapp.repository.RepositoryTestData.END_DATE;
import static org.example.hotelbookingapp.repository.RepositoryTestData.HOTEL;
import static org.example.hotelbookingapp.repository.RepositoryTestData.ROOM;
import static org.example.hotelbookingapp.repository.RepositoryTestData.USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        // clean repository
        roomRepository.deleteAll();
        assertTrue(roomRepository.findAll().isEmpty());

        Hotel hotel = entityManager.persistAndFlush(HOTEL);
        User user = entityManager.persistAndFlush(USER);
        Booking booking = BOOKING.toBuilder().user(user).room(hotel.getRooms().iterator().next()).build();
        user.addBooking(booking);
        booking.getRoom().addBooking(booking);
        booking = entityManager.persistAndFlush(booking);

    }

    @Test
    void findReservedByDateTest() {
        Collection<Room> rooms = roomRepository.findFreeRooms(END_DATE, END_DATE);
        assertFalse(rooms.isEmpty());
        assertTrue(rooms.size() == 1);

        Room actual = rooms.iterator().next();
        assertEquals(ROOM.getHotel().getTitle(), actual.getHotel().getTitle());
    }

    @Test
    void findAllByBedCountTest() {
        Collection<Room> rooms = roomRepository.findAllByBedCount((byte) 1);
        assertFalse(rooms.isEmpty());
        assertTrue(rooms.size() == 1);

        Room actual = rooms.iterator().next();
        assertEquals(ROOM.getHotel().getTitle(), actual.getHotel().getTitle());
    }

}