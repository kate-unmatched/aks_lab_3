package com.coworking.booking.controller;

import com.coworking.booking.entity.Booking;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * API-контракт для управления бронированиями комнат.
 * <p>
 * Интерфейс определяет операции просмотра списка бронирований,
 * создания нового бронирования и удаления существующего.
 * Каждая реализация обязана учитывать бизнес-валидацию,
 * например проверку пересечения тайм-слотов или бронирование в прошлом.
 */
@RequestMapping("/rooms/{roomId}/bookings")
public interface BookingControllerApi {

    /**
     * Отображает список всех бронирований для указанной комнаты.
     *
     * @param roomId идентификатор комнаты
     * @param model  модель представления, содержащая данные для UI
     * @return имя Thymeleaf-шаблона со списком бронирований
     */
    @GetMapping
    String list(@PathVariable("roomId") Long roomId, Model model);

    /**
     * Открывает форму создания нового бронирования для выбранной комнаты.
     *
     * @param roomId идентификатор комнаты
     * @param model  модель для передачи в представление
     * @return имя Thymeleaf-шаблона с формой бронирования
     */
    @GetMapping("/create")
    String createForm(@PathVariable("roomId") Long roomId, Model model);

    /**
     * Создает новое бронирование с валидацией бизнес-правил.
     * В случае ошибок (пересечение периодов, бронирование в прошлом)
     * метод должен вернуть форму с отображением сообщения об ошибке.
     *
     * @param roomId  идентификатор комнаты, для которой создаётся бронирование
     * @param booking объект бронирования, переданный с формы
     * @param model   модель для передачи данных обратно в UI при ошибках
     * @return редирект на список бронирований или форма в случае ошибки
     */
    @PostMapping
    String create(@PathVariable("roomId") Long roomId,
                  @ModelAttribute Booking booking,
                  Model model);

    /**
     * Удаляет выбранное бронирование.
     *
     * @param roomId     идентификатор комнаты
     * @param bookingId  идентификатор удаляемого бронирования
     * @return редирект обратно на список бронирований комнаты
     */
    @PostMapping("/{bookingId}/delete")
    String delete(@PathVariable("roomId") Long roomId,
                  @PathVariable("bookingId") Long bookingId);
}

