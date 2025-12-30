package com.coworking.booking.dto;

import lombok.Data;

@Data
public class RoomDto {
    private Long id;
    private String roomName;
    private Integer seats;
    private Boolean available;
}
