package org.example.hotelbookingapp.repository;

import org.example.hotelbookingapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r JOIN r.bookings b WHERE b.startDate > :endDate OR b.endDate < :startDate")
    Collection<Room> findFreeRooms(LocalDate startDate, LocalDate endDate);

    Collection<Room> findAllByBedCount(byte bedCount);
}
