package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.BookingDto;
import com.coworking.booking.dto.BookingListDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(
        value = "/api/v2/workspaces/{workspaceId}/rooms/{roomId}/bookings",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
public interface BookingRestApi {

    @GetMapping
    BookingListDto getAll(@PathVariable Long workspaceId,
                          @PathVariable Long roomId);

    @GetMapping("/new")
    BookingDto getForCreate(@PathVariable Long workspaceId,
                            @PathVariable Long roomId);

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    BookingDto create(@PathVariable Long workspaceId,
                      @PathVariable Long roomId,
                      @RequestBody BookingDto dto);

    @DeleteMapping("/{bookingId}")
    void delete(@PathVariable Long workspaceId,
                @PathVariable Long roomId,
                @PathVariable Long bookingId);
}
