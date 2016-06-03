package com.asinovich.dto;

import com.asinovich.domain.RecordSpentTime;

import java.util.Calendar;

/**
 *
 * @author Nicolas Asinovich.
 */
public class RecordSpentTimeDTO {

    private String id;
    private EmployeeDTO employeeNameDTO;
    private Calendar calendarInsertRecord;
    private String numberOfHour;
    private TaskDTO nameTaskDTO;

    public RecordSpentTimeDTO (RecordSpentTime recordSpentTime) {
        this.id = Long.toString(recordSpentTime.getId());
        this.employeeNameDTO = new EmployeeDTO(recordSpentTime.getEmployeeName());
        this.calendarInsertRecord = recordSpentTime.getCalendarInsertRecord();
        this.numberOfHour = Integer.toString(recordSpentTime.getNumberOfHour());
        this.nameTaskDTO = new TaskDTO(recordSpentTime.getNameTask());
    }

    public RecordSpentTimeDTO () {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public EmployeeDTO getEmployeeNameDTO () {
        return employeeNameDTO;
    }

    public void setEmployeeNameDTO (EmployeeDTO employeeNameDTO) {
        this.employeeNameDTO = employeeNameDTO;
    }

    public Calendar getCalendarInsertRecord () {
        return calendarInsertRecord;
    }

    public void setCalendarInsertRecord (Calendar calendarInsertRecord) {
        this.calendarInsertRecord = calendarInsertRecord;
    }

    public String getNumberOfHour () {
        return numberOfHour;
    }

    public void setNumberOfHour (String numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    public TaskDTO getNameTaskDTO () {
        return nameTaskDTO;
    }

    public void setNameTaskDTO (TaskDTO nameTaskDTO) {
        this.nameTaskDTO = nameTaskDTO;
    }

}
