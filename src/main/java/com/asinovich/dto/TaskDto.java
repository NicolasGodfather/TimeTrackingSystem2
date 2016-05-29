package com.asinovich.dto;

import com.asinovich.domain.RecordSpentTime;
import com.asinovich.domain.Task;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class TaskDto {

    private String id;

    private String taskName;

    private String employee;

    private List<RecordSpentTime> listRecordSpentTime;

    public TaskDto (Task task) {
        this.id = Long.toString(task.getId());
        this.taskName = task.getTaskName();
        this.employee = task.getEmployee();
        this.listRecordSpentTime = task.getListRecordSpentTime();
    }

    public TaskDto () {
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

    public String getEmployee () {
        return employee;
    }

    public void setEmployee (String employee) {
        this.employee = employee;
    }

    public List<RecordSpentTime> getListRecordSpentTime () {
        return listRecordSpentTime;
    }

    public void setListRecordSpentTime (List<RecordSpentTime> listRecordSpentTime) {
        this.listRecordSpentTime = listRecordSpentTime;
    }
}
