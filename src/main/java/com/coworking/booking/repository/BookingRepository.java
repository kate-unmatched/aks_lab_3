package com.coworking.booking.repository;

import com.coworking.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByRoomId(Long roomId);

    boolean existsByRoomIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Long roomId,
            LocalDateTime end,
            LocalDateTime start
    );
}
