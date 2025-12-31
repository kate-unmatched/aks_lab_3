package com.coworking.booking.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

@JacksonXmlRootElement(localName = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {

    @JacksonXmlProperty
    private Long id;

    @JacksonXmlProperty
    private String bookedBy;

    // ISO-строки для UI / JSON / XML
    @JacksonXmlProperty
    private String startTime;

    @JacksonXmlProperty
    private String endTime;

    @JacksonXmlProperty
    private Long roomId;

    @JacksonXmlProperty
    private String roomName;

    @JacksonXmlProperty
    private Long workspaceId;
}
