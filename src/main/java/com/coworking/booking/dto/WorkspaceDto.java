package com.coworking.booking.dto;

import com.coworking.booking.entity.WorkspaceType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JacksonXmlRootElement(localName = "workspace")
public class WorkspaceDto {

    private Long id;
    private String name;
    private WorkspaceType type;
    private Integer capacity;
    private Boolean available;
}
