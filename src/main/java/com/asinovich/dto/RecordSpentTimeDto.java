package com.asinovich.dto;

import com.asinovich.domain.RecordSpentTime;

import java.util.Calendar;

/**
 *
 * @author Nicolas Asinovich.
 */
public class RecordSpentTimeDTO {

    private String id;

    private String employeeName;

    private Calendar calendarInsertRecord;

    private int numberOfHour;

    public RecordSpentTimeDTO (RecordSpentTime recordSpentTime) {
        this.id = Long.toString(recordSpentTime.getId());
        this.employeeName = recordSpentTime.getEmployeeName();
        this.calendarInsertRecord = recordSpentTime.getCalendarInsertRecord();
        this.numberOfHour = recordSpentTime.getNumberOfHour();
    }

    public RecordSpentTimeDTO () {
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

    public Calendar getCalendarInsertRecord () {
        return calendarInsertRecord;
    }

    public void setCalendarInsertRecord (Calendar calendarInsertRecord) {
        this.calendarInsertRecord = calendarInsertRecord;
    }

    public int getNumberOfHour () {
        return numberOfHour;
    }

    public void setNumberOfHour (int numberOfHour) {
        this.numberOfHour = numberOfHour;
    }
}
