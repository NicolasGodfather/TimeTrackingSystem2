package com.asinovich.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Реализация задачи как сущности
 * Задача содержит следующую информацию:
        1. Название.
        2. Ответственное за задачу лицо.
        3. Список записей затраченного времени.
 *
 * @author Nicolas Asinovich.
 */

@Entity
@Table (name = "task")
public class Task {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "taskName")
    private String taskName;

    @Column (name = "employee")
    private String employee;

    @Column (name = "listRecordSpentTime")
    private List<RecordSpentTime> listRecordSpentTime;

    public long getId () {
        return id;
    }

    public void setId (long id) {
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
