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

    private Calendar calendarInsertRecord;

    private int numberOfHour;

    @ManyToOne
    @JoinColumn(name = "employeeNameId")
    private Employee employeeName;

    @ManyToOne
    @JoinColumn(name = "nameTaskId")
    private Task nameTask;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public Employee getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (Employee employeeName) {
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

    public Task getNameTask () {
        return nameTask;
    }

    public void setNameTask (Task nameTask) {
        this.nameTask = nameTask;
    }
}
