package com.coworking.booking.controller;

import com.coworking.booking.entity.Room;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * API-контракт для управления комнатами в рамках выбранного рабочего пространства.
 * <p>
 * Содержит методы для отображения списка комнат, создания новой комнаты,
 * редактирования и удаления. Реализация обязана выполнять привязку комнаты
 * к workspace и обеспечивать корректную работу валидации.
 */
@RequestMapping("/workspaces/{workspaceId}/rooms")
public interface RoomControllerApi {

    /**
     * Отображает список комнат внутри рабочего пространства.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param model       модель для передачи данных в представление
     * @return thymeleaf-шаблон со списком комнат
     */
    @GetMapping
    String list(@PathVariable("workspaceId") Long workspaceId, Model model);

    /**
     * Открывает форму для создания новой комнаты.
     * Контроллер реализации должен предварительно создать объект Room
     * и привязать его к workspace.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param model       модель для передачи объекта Room и workspace
     * @return thymeleaf-шаблон формы создания комнаты
     */
    @GetMapping("/create")
    String createRoomForm(@PathVariable("workspaceId") Long workspaceId, Model model);

    /**
     * Создаёт новую комнату и привязывает её к workspace.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param room        объект комнаты, полученный из формы
     * @return редирект на страницу со списком комнат
     */
    @PostMapping
    String createRoom(@PathVariable("workspaceId") Long workspaceId,
                      @ModelAttribute Room room);

    /**
     * Открывает форму редактирования комнаты.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param roomId      идентификатор комнаты
     * @param model       модель с данными комнаты
     * @return thymeleaf-шаблон формы редактирования
     */
    @GetMapping("/{roomId}/edit")
    String editForm(@PathVariable("workspaceId") Long workspaceId,
                    @PathVariable("roomId") Long roomId,
                    Model model);

    /**
     * Обновляет параметры существующей комнаты.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param roomId      идентификатор комнаты
     * @param room        изменённый объект комнаты
     * @return редирект на список комнат
     */
    @PostMapping("/{roomId}/edit")
    String edit(@PathVariable("workspaceId") Long workspaceId,
                @PathVariable("roomId") Long roomId,
                @ModelAttribute Room room);

    /**
     * Удаляет комнату из рабочего пространства.
     *
     * @param workspaceId идентификатор рабочего пространства
     * @param roomId      идентификатор комнаты
     * @return редирект на список комнат
     */
    @PostMapping("/{roomId}/delete")
    String delete(@PathVariable("workspaceId") Long workspaceId,
                  @PathVariable("roomId") Long roomId);
}
