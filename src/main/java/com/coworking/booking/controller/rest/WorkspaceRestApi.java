package com.coworking.booking.controller.rest;

import com.coworking.booking.dto.WorkspaceDto;
import com.coworking.booking.dto.WorkspaceListDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(
        value = "/api/v2/workspaces",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE
        }
)
public interface WorkspaceRestApi {

    @GetMapping
    WorkspaceListDto getAll();

    @GetMapping("/new")
    WorkspaceDto getForCreate();

    @GetMapping("/{id}/edit")
    WorkspaceDto getForEdit(@PathVariable Long id);

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    WorkspaceDto create(@RequestBody WorkspaceDto dto);

    @PutMapping(
            value = "/{id}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    WorkspaceDto update(@PathVariable Long id,
                        @RequestBody WorkspaceDto dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
