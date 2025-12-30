package com.coworking.booking.controller;

import com.coworking.booking.entity.Workspace;
import com.coworking.booking.entity.WorkspaceType;
import com.coworking.booking.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class WorkspaceController implements WorkspaceControllerApi {

    private final WorkspaceService workspaceService;

    @Override
    public String list(Model model) {
        model.addAttribute("workspaces", workspaceService.getAll());
        return "workspaces/list";
    }

    @Override
    public String details(Long id, Model model) {
        model.addAttribute("workspace", workspaceService.getById(id));
        return "workspaces/details";
    }

    @Override
    public String createForm(Model model) {
        model.addAttribute("workspace", new Workspace());
        model.addAttribute("types", WorkspaceType.values());
        return "workspaces/create";
    }

    @Override
    public String create(Workspace workspace) {
        workspace.setAvailable(true);
        workspaceService.create(workspace);
        return "redirect:/workspaces/list";
    }

    @Override
    public String delete(Long id) {
        workspaceService.delete(id);
        return "redirect:/workspaces/list";
    }

    @Override
    public String index() {
        return "redirect:/workspaces/list";
    }

    @Override
    public String edit(Long id, Model model) {
        model.addAttribute("workspace", workspaceService.getById(id));
        model.addAttribute("types", WorkspaceType.values());
        return "workspaces/edit";
    }

    @Override
    public String update(Long id, Workspace workspace) {
        workspaceService.update(id, workspace);
        return "redirect:/workspaces/list";
    }
}
