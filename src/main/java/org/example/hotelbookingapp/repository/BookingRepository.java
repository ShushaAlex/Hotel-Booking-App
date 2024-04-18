package org.example.hotelbookingapp.repository;

import org.example.hotelbookingapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.startDate <= ?1 AND b.endDate >= ?2")
    Collection<Booking> findReservedByDate(LocalDate startDate, LocalDate endDate);

}
