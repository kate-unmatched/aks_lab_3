package com.coworking.booking.repository;

import com.coworking.booking.entity.Room;

import java.util.List;

public interface RoomRepository extends BaseRepository<Room, Long> {

    List<Room> findByWorkspaceId(Long workspaceId);

}
