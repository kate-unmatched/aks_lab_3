package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.RoomDto;
import com.coworking.booking.dto.RoomsListDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(
        value = "/api/v2/workspaces/{workspaceId}/rooms",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
public interface RoomRestApi {

    @GetMapping
    RoomsListDto getAll(@PathVariable("workspaceId") Long workspaceId);

    @GetMapping("/new")
    RoomDto getForCreate(@PathVariable("workspaceId") Long workspaceId);

    @GetMapping("/{roomId}/edit")
    RoomDto getForEdit(@PathVariable("workspaceId") Long workspaceId,
                       @PathVariable("roomId") Long roomId);

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    RoomDto create(@PathVariable("workspaceId") Long workspaceId,
                   @RequestBody RoomDto dto);

    @PutMapping("/{roomId}")
    RoomDto update(@PathVariable("workspaceId") Long workspaceId,
                   @PathVariable("roomId") Long roomId,
                   @RequestBody RoomDto dto);

    @DeleteMapping("/{roomId}")
    void delete(@PathVariable("workspaceId") Long workspaceId,
                @PathVariable("roomId") Long roomId);
}

