package com.asinovich.controllers.forms;

import com.asinovich.dto.TaskDTO;

/**
 *
 * @author Nicolas Asinovich.
 */
public class TaskForm {

    private String id;
    private String taskName;
    private String responsibleEmployee;
    private String taskOfProject;

    public TaskForm () {
    }

    public TaskForm (TaskDTO taskDTO) {
        this.id = taskDTO.getId();
        this.taskName = taskDTO.getTaskName();
        this.responsibleEmployee = taskDTO.getResponsibleEmployee().getId();
        this.taskOfProject = taskDTO.getTaskOfProject().getId();
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

    public String getTaskOfProject () {
        return taskOfProject;
    }

    public void setTaskOfProject (String taskOfProject) {
        this.taskOfProject = taskOfProject;
    }

    @Override
    public String toString () {
        return "TaskForm{" +
                "taskName='" + taskName + '\'' +
                ", responsibleEmployee='" + responsibleEmployee + '\'' +
                '}';
    }
}
