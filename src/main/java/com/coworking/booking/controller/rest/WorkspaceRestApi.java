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

    // 📌 список (XML / JSON)
    @GetMapping
    WorkspaceListDto getAll();

    // 📌 форма СОЗДАНИЯ (UI, XSL)
    @GetMapping("/new")
    WorkspaceDto getForCreate();

    // 📌 форма РЕДАКТИРОВАНИЯ (UI, XSL)
    @GetMapping("/{id}/edit")
    WorkspaceDto getForEdit(@PathVariable Long id);

    // 📌 создание (DATA, JSON / XML)
    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    WorkspaceDto create(@RequestBody WorkspaceDto dto);

    // 📌 обновление (DATA, JSON / XML)
    @PutMapping(
            value = "/{id}",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            }
    )
    WorkspaceDto update(@PathVariable Long id,
                        @RequestBody WorkspaceDto dto);

    // 📌 удаление (DATA)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id);
}
