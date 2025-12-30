package com.coworking.booking.controller;

import com.coworking.booking.entity.Room;
import com.coworking.booking.entity.Workspace;
import com.coworking.booking.service.RoomService;
import com.coworking.booking.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class RoomController implements RoomControllerApi {

    private final RoomService roomService;
    private final WorkspaceService workspaceService;

    @Override
    public String list(Long workspaceId, Model model) {
        model.addAttribute("workspace", workspaceService.getById(workspaceId));
        model.addAttribute("rooms", roomService.getRoomsByWorkspace(workspaceId));
        return "rooms/list";
    }

    @Override
    public String createRoomForm(Long workspaceId, Model model) {
        Workspace workspace = workspaceService.getById(workspaceId);

        Room room = new Room();
        room.setWorkspace(workspace);

        model.addAttribute("room", room);
        model.addAttribute("workspace", workspace);

        return "rooms/create";
    }

    @Override
    public String createRoom(Long workspaceId, Room room) {
        Workspace workspace = workspaceService.getById(workspaceId);
        room.setWorkspace(workspace);

        roomService.create(room);
        return "redirect:/workspaces/" + workspaceId + "/rooms";
    }

    @Override
    public String editForm(Long workspaceId, Long roomId, Model model) {
        Room room = roomService.getById(roomId);
        Workspace workspace = workspaceService.getById(workspaceId);

        model.addAttribute("room", room);
        model.addAttribute("workspace", workspace);

        return "rooms/edit";
    }

    @Override
    public String edit(Long workspaceId, Long roomId, Room room) {
        roomService.updateRoom(workspaceId, roomId, room);
        return "redirect:/workspaces/" + workspaceId + "/rooms";
    }

    @Override
    public String delete(Long workspaceId, Long roomId) {
        roomService.deleteRoom(workspaceId, roomId);
        return "redirect:/workspaces/" + workspaceId + "/rooms";
    }
}
