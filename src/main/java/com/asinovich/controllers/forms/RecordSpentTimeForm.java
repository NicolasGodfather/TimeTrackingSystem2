package com.asinovich.controllers.forms;

import com.asinovich.dto.RecordSpentTimeDTO;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class RecordSpentTimeForm {

    private String id;
    private String employeeName;
    private String calendarInsertRecord;
    private String numberOfHour;

    public RecordSpentTimeForm () {
    }

    public RecordSpentTimeForm (RecordSpentTimeDTO recordSpentTimeDTO) {
        this.id = recordSpentTimeDTO.getId();
        this.employeeName = recordSpentTimeDTO.getEmployeeName();
        this.calendarInsertRecord = String.valueOf(recordSpentTimeDTO.getCalendarInsertRecord());
        this.numberOfHour = String.valueOf(recordSpentTimeDTO.getNumberOfHour());
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCalendarInsertRecord () {
        return calendarInsertRecord;
    }

    public void setCalendarInsertRecord (String calendarInsertRecord) {
        this.calendarInsertRecord = calendarInsertRecord;
    }

    public String getNumberOfHour () {
        return numberOfHour;
    }

    public void setNumberOfHour (String numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    @Override
    public String toString () {
        return "RecordSpentTimeForm{" +
                "id='" + id + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", calendarInsertRecord='" + calendarInsertRecord + '\'' +
                ", numberOfHour='" + numberOfHour + '\'' +
                '}';
    }
}
