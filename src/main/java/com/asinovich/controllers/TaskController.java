package com.asinovich.controllers;

import com.asinovich.controllers.forms.TaskForm;
import com.asinovich.controllers.validator.TaskFormValidator;
import com.asinovich.dto.TaskDTO;
import com.asinovich.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 * TODO : still not finish
 *
 * @author Nicolas Asinovich.
 */
@Controller
public class TaskController {

    private static final String All_TASK = "allTask";
    private static final String SAVE_TASK = "saveTask";
    private static final String ERROR_PAGE = "errorPage";
    private static final String APPOINT = "appointEmployeeToProject";

    @Autowired
    private TaskFormValidator taskFormValidator;
    @Autowired
    private TaskService taskService;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(taskFormValidator);
    }

    @RequestMapping (value = "all/task", method = RequestMethod.GET)
    public String showAllTask(ModelMap modelMap) {
        modelMap.addAttribute("task", taskService.getAll());
        return All_TASK;
    }

    @RequestMapping(value = "/save/task", method = RequestMethod.GET)
    public String showPageAddTask(ModelMap modelMap) {
        modelMap.addAttribute("taskForm", new TaskForm());
        return SAVE_TASK;
    }

    @RequestMapping(value = "/save/task/{id}", method = RequestMethod.GET)
    public String showPageEditTask(@PathVariable (value = "id") Long id, ModelMap modelMap) {
        try {
            TaskDTO taskDTO = taskService.getById(id);
            modelMap.addAttribute("taskForm", new TaskForm(taskDTO));
            return SAVE_TASK;
        } catch (NullPointerException e) {
            return ERROR_PAGE;
        }
    }

    @RequestMapping(value = "/save/task", method = RequestMethod.POST)
    public String getSaveTask(@Validated TaskForm taskForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_TASK;
        }
        if ("".equals(taskForm.getId())) {
            TaskDTO taskDTO = getTaskDTO(taskForm);
            taskService.insert(taskDTO);
        } else {
            TaskDTO taskDTO = getTaskDTO(taskForm);
            taskDTO.setId(taskForm.getId());
            taskService.update(taskDTO);
        }
        return "redirect:/all/task";
    }

    private TaskDTO getTaskDTO(@Validated TaskForm taskForm) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTaskName(taskForm.getTaskName());
        return taskDTO;
    }

    @RequestMapping(value = "/delete/task/{id}", method = RequestMethod.GET)
    public RedirectView deleteTask(@PathVariable(value = "id") Long id) {
        taskService.deleteById(id);
        return new RedirectView("/all/task");
    }

}
