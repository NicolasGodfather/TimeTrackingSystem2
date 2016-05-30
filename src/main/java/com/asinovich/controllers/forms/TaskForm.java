package com.asinovich.controllers.forms;

import com.asinovich.dto.TaskDTO;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class TaskForm {

    private String id;
    private String taskName;
    private String responsibleEmployee;

    public TaskForm () {
    }

    public TaskForm (TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.taskName = taskDTO.getTaskName();
        this.responsibleEmployee = taskDTO.getResponsibleEmployee().getId();
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getTaskName () {
        return taskName;
    }

    public void setTaskName (String taskName) {
        this.taskName = taskName;
    }

    public String getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    @Override
    public String toString () {
        return "TaskForm{" +
                "taskName='" + taskName + '\'' +
                ", responsibleEmployee='" + responsibleEmployee + '\'' +
                '}';
    }
}
