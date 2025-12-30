package com.coworking.booking.controller;

import com.coworking.booking.entity.Workspace;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * API-контракт для управления рабочими пространствами (workspaces).
 * <p>
 * Содержит операции для:
 * — просмотра списка и деталей workspace,
 * — создания нового рабочего пространства,
 * — редактирования существующего,
 * — удаления,
 * — обработки корневого маршрута контроллера.
 * <p>
 */
@RequestMapping("/workspaces")
public interface WorkspaceControllerApi {

    /**
     * Отображает список всех рабочих пространств.
     *
     * @param model модель для передачи списка workspace в представление
     * @return thymeleaf-шаблон со списком рабочих пространств
     */
    @GetMapping("/list")
    String list(Model model);

    /**
     * Отображает детали конкретного рабочего пространства.
     *
     * @param id    идентификатор рабочего пространства
     * @param model модель с данными workspace
     * @return шаблон с детальной информацией
     */
    @GetMapping("/{id}")
    String details(@PathVariable("id") Long id, Model model);

    /**
     * Открывает форму создания нового рабочего пространства.
     *
     * @param model модель для передачи нового объекта {@link Workspace}
     * @return thymeleaf-шаблон формы создания
     */
    @GetMapping("/create")
    String createForm(Model model);

    /**
     * Создаёт новое рабочее пространство.
     *
     * @param workspace объект workspace, полученный из формы
     * @return редирект на список рабочих пространств
     */
    @PostMapping("/create")
    String create(@ModelAttribute Workspace workspace);

    /**
     * Удаляет рабочее пространство по ID.
     *
     * @param id идентификатор workspace
     * @return редирект на список пространств после удаления
     */
    @DeleteMapping("/{id}")
    String delete(@PathVariable("id") Long id);

    /**
     * Отображает страницу по умолчанию для контроллера.
     * Перенаправляет на список.
     *
     * @return редирект на /workspaces/list
     */
    @GetMapping("/")
    String index();

    /**
     * Открывает форму редактирования workspace.
     *
     * @param id    идентификатор workspace
     * @param model модель с текущими данными workspace
     * @return thymeleaf-шаблон формы редактирования
     */
    @GetMapping("/{id}/edit")
    String edit(@PathVariable("id") Long id, Model model);

    /**
     * Обновляет существующее рабочее пространство.
     *
     * @param id        идентификатор workspace
     * @param workspace изменённые данные рабочего пространства
     * @return редирект на список рабочих пространств
     */
    @PostMapping("/{id}/update")
    String update(@PathVariable("id") Long id,
                  @ModelAttribute Workspace workspace);
}
