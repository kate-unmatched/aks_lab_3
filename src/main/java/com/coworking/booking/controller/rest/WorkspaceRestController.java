package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.WorkspaceDto;
import com.coworking.booking.dto.WorkspaceListDto;
import com.coworking.booking.entity.Workspace;
import com.coworking.booking.entity.WorkspaceType;
import com.coworking.booking.service.WorkspaceService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkspaceRestController implements WorkspaceRestApi {

    private final WorkspaceService workspaceService;

    public WorkspaceRestController(WorkspaceService workspaceService) {
        this.workspaceService = workspaceService;
    }

    @Override
    public WorkspaceListDto getAll() {
        List<WorkspaceDto> items = workspaceService.getAll()
                .stream()
                .map(this::toDto)
                .toList();

        return new WorkspaceListDto(items);
    }

    @Override
    public WorkspaceDto getForCreate() {
        return new WorkspaceDto(
                null,
                "",
                WorkspaceType.OPEN_SPACE,
                1,
                true
        );
    }

    @Override
    public WorkspaceDto getForEdit(Long id) {
        Workspace workspace = workspaceService.getById(id);
        return toDto(workspace);
    }

    @Override
    public WorkspaceDto create(WorkspaceDto dto) {
        Workspace created = workspaceService.create(fromDto(dto));
        return toDto(created);
    }

    @Override
    public WorkspaceDto update(Long id, WorkspaceDto dto) {
        Workspace updated = workspaceService.update(id, fromDto(dto));
        return toDto(updated);
    }

    @Override
    public void delete(Long id) {
        workspaceService.delete(id);
    }

    private WorkspaceDto toDto(Workspace workspace) {
        return new WorkspaceDto(
                workspace.getId(),
                workspace.getName(),
                workspace.getType(),
                workspace.getCapacity(),
                workspace.getAvailable()
        );
    }

    private Workspace fromDto(WorkspaceDto dto) {
        return Workspace.builder()
                .name(dto.getName())
                .type(dto.getType())
                .capacity(dto.getCapacity())
                .available(dto.getAvailable())
                .build();
    }
}
