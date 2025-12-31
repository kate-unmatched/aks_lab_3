package com.coworking.booking.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import java.util.List;

@JacksonXmlRootElement(localName = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingListDto {

    @JacksonXmlProperty
    private Long workspaceId;

    @JacksonXmlProperty
    private Long roomId;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "booking")
    private List<BookingDto> bookings;
}

