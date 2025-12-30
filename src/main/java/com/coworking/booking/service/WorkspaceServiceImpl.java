package com.coworking.booking.service;

import com.coworking.booking.entity.Workspace;
import com.coworking.booking.repository.WorkspaceRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl extends BaseServiceImpl<Workspace, Long> implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public WorkspaceServiceImpl(WorkspaceRepository workspaceRepository) {
        super(workspaceRepository);
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public Workspace update(Long id, Workspace updated) {
        Workspace existing = getById(id);

        existing.setName(updated.getName());
        existing.setType(updated.getType());
        existing.setCapacity(updated.getCapacity());
        existing.setAvailable(updated.getAvailable());

        repository.save(existing);
        return existing;
    }

}
