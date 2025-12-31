package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.RoomDto;
import com.coworking.booking.dto.RoomListDto;
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

    // список комнат
    @GetMapping
    RoomListDto getAll(@PathVariable Long workspaceId);

    // форма создания (XML + XSL)
    @GetMapping("/new")
    RoomDto getForCreate(@PathVariable Long workspaceId);

    // форма редактирования (XML + XSL)
    @GetMapping("/{roomId}/edit")
    RoomDto getForEdit(@PathVariable Long workspaceId,
                       @PathVariable Long roomId);

    // создание
    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    RoomDto create(@PathVariable Long workspaceId,
                   @RequestBody RoomDto dto);

    // обновление
    @PutMapping(
            value = "/{roomId}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    RoomDto update(@PathVariable Long workspaceId,
                   @PathVariable Long roomId,
                   @RequestBody RoomDto dto);

    // удаление
    @DeleteMapping("/{roomId}")
    void delete(@PathVariable Long workspaceId,
                @PathVariable Long roomId);
}
