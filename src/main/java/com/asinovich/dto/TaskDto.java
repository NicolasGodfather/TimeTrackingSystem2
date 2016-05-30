package com.asinovich.dto;

import com.asinovich.domain.Task;

import java.util.List;

/**
 *
 * @author Nicolas Asinovich.
 */
public class TaskDTO {

    private String id;

    private String taskName;

    private EmployeeDTO responsibleEmployee;

    private List<RecordSpentTimeDTO> recordSpentTimeDTOs;

    public TaskDTO (Task task) {
        this.id = Long.toString(task.getId());
        this.taskName = task.getTaskName();
        this.responsibleEmployee = new EmployeeDTO(task.getResponsibleEmployee());
    }

    public TaskDTO () {
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

    public EmployeeDTO getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (EmployeeDTO responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public List<RecordSpentTimeDTO> getRecordSpentTimeDTOs () {
        return recordSpentTimeDTOs;
    }

    public void setRecordSpentTimeDTOs (List<RecordSpentTimeDTO> recordSpentTimeDTOs) {
        this.recordSpentTimeDTOs = recordSpentTimeDTOs;
    }
}
