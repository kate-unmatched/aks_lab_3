package com.coworking.booking.web;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.nio.charset.StandardCharsets;

@ControllerAdvice
public class XmlStylesheetAdvice implements ResponseBodyAdvice<Object> {

    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public boolean supports(
            MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType
    ) {
        // Применяем ко всем ответам, фильтруем по Content-Type ниже
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request,
            ServerHttpResponse response
    ) {

        if (!MediaType.APPLICATION_XML.includes(selectedContentType)) {
            return body;
        }

        if (!(response instanceof ServletServerHttpResponse servletResponse)) {
            return body;
        }

        try {
            // сериализуем объект в XML
            String xmlBody = xmlMapper.writeValueAsString(body);

            // определяем, какой XSL подключать
            String path = request.getURI().getPath();
            String xslPath;

            if (path.endsWith("/new")) {
                xslPath = "/xsl/workspace-create.xsl";
            } else if (path.matches(".*/api/v2/workspaces/\\d+$")) {
                xslPath = "/xsl/workspace-edit.xsl";
            } else {
                xslPath = "/xsl/workspaces.xsl";
            }

            if (path.endsWith("/rooms/new")) {
                xslPath = "/xsl/room-create.xsl";

            } else if (path.contains("/rooms/") && path.endsWith("/edit")) {
                xslPath = "/xsl/room-edit.xsl";

            } else if (path.endsWith("/rooms")) {
                xslPath = "/xsl/rooms.xsl";
            }

            if (path.endsWith("/bookings/new")) {
                xslPath = "/xsl/booking-create.xsl";

            } else if (path.endsWith("/bookings")) {
                xslPath = "/xsl/bookings.xsl";
            }



            // финальный XML с processing instruction
            String finalXml = """
                <?xml version="1.0" encoding="UTF-8"?>
                <?xml-stylesheet type="text/xsl" href="%s"?>
                %s
                """.formatted(xslPath, xmlBody);

            // пишем ответ вручную
            servletResponse.getServletResponse().setContentType("application/xml");
            servletResponse.getServletResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
            servletResponse.getServletResponse().getWriter().write(finalXml);
            servletResponse.getServletResponse().getWriter().flush();

            // ⛔ ВАЖНО: Spring больше ничего не сериализует
            return null;

        } catch (Exception e) {
            throw new RuntimeException("Failed to apply XSLT to XML response", e);
        }
    }
}
