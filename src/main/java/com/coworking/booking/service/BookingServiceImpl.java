package com.coworking.booking.service;

import com.coworking.booking.entity.Booking;
import com.coworking.booking.entity.Room;
import com.coworking.booking.repository.BookingRepository;
import com.coworking.booking.repository.RoomRepository;
import com.coworking.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Override
    public List<Booking> getBookingsByRoom(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    @Override
    public Booking getById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + id));
    }

    @Override
    public Booking create(Long roomId, Booking booking) {

        if (booking.getStartTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Cannot create booking in the past");
        }

        if (booking.getEndTime().isBefore(booking.getStartTime())) {
            throw new IllegalStateException("End time must be after start time");
        }

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomId));

        booking.setRoom(room);

        // Проверяем пересечение
        if (bookingRepository.existsByRoomIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                roomId,
                booking.getEndTime(),
                booking.getStartTime()
        )) {
            throw new IllegalArgumentException("This time slot is already booked.");
        }

        return bookingRepository.save(booking);
    }

    @Override
    public void delete(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
