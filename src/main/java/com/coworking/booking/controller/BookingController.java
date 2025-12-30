package com.coworking.booking.controller;

import com.coworking.booking.entity.Booking;
import com.coworking.booking.entity.Room;
import com.coworking.booking.service.BookingService;
import com.coworking.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BookingController implements BookingControllerApi {

    private final BookingService bookingService;
    private final RoomService roomService;

    @Override
    public String list(@PathVariable Long roomId, Model model) {
        Room room = roomService.getById(roomId);

        model.addAttribute("room", room);
        model.addAttribute("bookings", bookingService.getBookingsByRoom(roomId));

        return "bookings/list";
    }

    @Override
    public String createForm(@PathVariable Long roomId, Model model) {
        Room room = roomService.getById(roomId);

        Booking booking = new Booking();
        booking.setRoom(room);

        model.addAttribute("room", room);
        model.addAttribute("booking", booking);

        return "bookings/create";
    }

    @Override
    public String create(@PathVariable Long roomId,
                         @ModelAttribute Booking booking,
                         Model model) {

        Room room = roomService.getById(roomId);
        booking.setRoom(room);

        try {
            bookingService.create(roomId, booking);
            return "redirect:/rooms/" + roomId + "/bookings";
        } catch (IllegalStateException ex) {
            model.addAttribute("room", room);
            model.addAttribute("booking", booking);
            model.addAttribute("errorMessage", ex.getMessage());
            return "bookings/create";
        }
    }

    @Override
    public String delete(@PathVariable Long roomId,
                         @PathVariable Long bookingId) {
        bookingService.delete(bookingId);
        return "redirect:/rooms/" + roomId + "/bookings";
    }
}
