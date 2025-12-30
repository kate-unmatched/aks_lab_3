package com.coworking.booking.service;

import com.coworking.booking.entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getBookingsByRoom(Long roomId);

    Booking getById(Long id);

    Booking create(Long roomId, Booking booking);

    void delete(Long bookingId);
}
