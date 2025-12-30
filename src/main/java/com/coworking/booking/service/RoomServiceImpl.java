package com.coworking.booking.service;

import com.coworking.booking.entity.Room;
import com.coworking.booking.entity.Workspace;
import com.coworking.booking.repository.RoomRepository;
import com.coworking.booking.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl extends BaseServiceImpl<Room, Long> implements RoomService {

    private final RoomRepository roomRepository;
    private final WorkspaceRepository workspaceRepository;

    public RoomServiceImpl(RoomRepository roomRepository,
                           WorkspaceRepository workspaceRepository) {
        super(roomRepository);
        this.roomRepository = roomRepository;
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public List<Room> getByWorkspace(Long workspaceId) {
        return roomRepository.findByWorkspaceId(workspaceId);
    }

    @Override
    public Room create(Room room, Long workspaceId) {
        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new IllegalArgumentException("Workspace not found: " + workspaceId));

        room.setWorkspace(workspace);
        return roomRepository.save(room);
    }

    public List<Room> getRoomsByWorkspace(Long workspaceId) {
        return roomRepository.findByWorkspaceId(workspaceId);
    }

    @Override
    public Room createRoom(Long workspaceId, Room room) {
        Workspace ws = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));

        room.setWorkspace(ws);
        return roomRepository.save(room);
    }

    public Room updateRoom(Long workspaceId, Long roomId, Room updated) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        if (!room.getWorkspace().getId().equals(workspaceId)) {
            throw new RuntimeException("Workspace mismatch");
        }

        room.setRoomName(updated.getRoomName());
        room.setSeats(updated.getSeats());
        room.setAvailable(updated.getAvailable());

        return roomRepository.save(room);
    }


    @Override
    public void deleteRoom(Long workspaceId, Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
