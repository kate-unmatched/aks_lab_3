package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.RoomDto;
import com.coworking.booking.dto.RoomListDto;
import com.coworking.booking.entity.Room;
import com.coworking.booking.entity.Workspace;
import com.coworking.booking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoomRestController implements RoomRestApi {

    private final RoomService roomService;

    @Override
    public RoomListDto getAll(Long workspaceId) {
        return new RoomListDto(
                roomService.getRoomsByWorkspace(workspaceId)
                        .stream()
                        .map(this::toDto)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public RoomDto getForCreate(Long workspaceId) {
        return RoomDto.builder()
                .workspaceId(workspaceId)
                .available(true)
                .build();
    }

    @Override
    public RoomDto getForEdit(Long workspaceId, Long roomId) {
        return toDto(roomService.getById(roomId));
    }

    @Override
    public RoomDto create(Long workspaceId, RoomDto dto) {
        Room room = toEntity(dto);
        Room saved = roomService.createRoom(workspaceId, room);
        return toDto(saved);
    }

    @Override
    public RoomDto update(Long workspaceId, Long roomId, RoomDto dto) {
        Room updated = roomService.updateRoom(workspaceId, roomId, toEntity(dto));
        return toDto(updated);
    }

    @Override
    public void delete(Long workspaceId, Long roomId) {
        roomService.deleteRoom(workspaceId, roomId);
    }

    // ===== mapping =====

    private RoomDto toDto(Room room) {
        return RoomDto.builder()
                .id(room.getId())
                .roomName(room.getRoomName())
                .seats(room.getSeats())
                .available(room.getAvailable())
                .workspaceId(room.getWorkspace().getId())
                .build();
    }

    private Room toEntity(RoomDto dto) {
        return Room.builder()
                .roomName(dto.getRoomName())
                .seats(dto.getSeats())
                .available(dto.getAvailable())
                .build();
    }
}
