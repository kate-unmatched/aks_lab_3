package com.coworking.booking.service;

import com.coworking.booking.entity.Workspace;

public interface WorkspaceService extends BaseService<Workspace, Long> {

    Workspace update(Long id, Workspace updated);

}

