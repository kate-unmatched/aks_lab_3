package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.BookingDto;
import com.coworking.booking.dto.BookingListDto;
import com.coworking.booking.entity.Booking;
import com.coworking.booking.entity.Room;
import com.coworking.booking.service.BookingService;
import com.coworking.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookingRestController implements BookingRestApi {

    private final BookingService bookingService;
    private final RoomService roomService;

    private static final DateTimeFormatter UI_FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public BookingListDto getAll(Long workspaceId, Long roomId) {
        Room room = roomService.getById(roomId);

        return BookingListDto.builder()
                .workspaceId(workspaceId)
                .roomId(roomId)
                .bookings(
                        bookingService.getBookingsByRoom(roomId)
                                .stream()
                                .map(b -> toDto(b, room, workspaceId))
                                .toList()
                )
                .build();
    }


    @Override
    public BookingDto getForCreate(Long workspaceId, Long roomId) {
        Room room = roomService.getById(roomId);

        return BookingDto.builder()
                .roomId(roomId)
                .roomName(room.getRoomName())
                .workspaceId(workspaceId)
                .build();
    }

    @Override
    public BookingDto create(Long workspaceId, Long roomId, BookingDto dto) {
        Room room = roomService.getById(roomId);

        Booking booking = Booking.builder()
                .bookedBy(dto.getBookedBy())
                .startTime(LocalDateTime.parse(dto.getStartTime()))
                .endTime(LocalDateTime.parse(dto.getEndTime()))
                .room(room)
                .build();

        Booking saved = bookingService.create(roomId, booking);
        return toDto(saved, room, workspaceId);
    }

    @Override
    public void delete(Long workspaceId, Long roomId, Long bookingId) {
        bookingService.delete(bookingId);
    }

    private BookingDto toDto(Booking b, Room room, Long workspaceId) {
        return BookingDto.builder()
                .id(b.getId())
                .bookedBy(b.getBookedBy())
                .startTime(b.getStartTime().format(UI_FMT))
                .endTime(b.getEndTime().format(UI_FMT))
                .roomId(room.getId())
                .roomName(room.getRoomName())
                .workspaceId(workspaceId)
                .build();
    }
}
