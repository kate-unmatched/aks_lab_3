package com.coworking.booking.service;

import com.coworking.booking.entity.Room;

import java.util.List;

public interface RoomService extends BaseService<Room, Long> {

    List<Room> getByWorkspace(Long workspaceId);

    Room create(Room room, Long workspaceId);

    List<Room> getRoomsByWorkspace(Long workspaceId);

    Room createRoom(Long workspaceId, Room room);

    Room updateRoom(Long workspaceId, Long roomId, Room room);

    void deleteRoom(Long workspaceId, Long roomId);
}