package com.asinovich.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Реализация Записи Затраченного Времени как Сущности
 * Запись затраченного времени содержит следующую информацию:
        1. Имя и фамилия человека, вносящего запись.
        2. Дата внесения записи.
        3. Количество затраченных часов.
 *
 * @author Nicolas Asinovich.
 */

@Entity
public class RecordSpentTime {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String employeeName;

    private Calendar calendarInsertRecord;

    private int numberOfHour;

    public long getId () {
        return id;
    }

    public void setId (long id) {
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
