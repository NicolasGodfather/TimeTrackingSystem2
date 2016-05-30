package com.asinovich.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Реализация Задачи как Сущности
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

    @Column (name = "responsibleEmployee")
    private String responsibleEmployee;

    @Column (name = "listRecordSpentTime")
//    @ManyToOne
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

    public String getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public List<RecordSpentTime> getListRecordSpentTime () {
        return listRecordSpentTime;
    }

    public void setListRecordSpentTime (List<RecordSpentTime> listRecordSpentTime) {
        this.listRecordSpentTime = listRecordSpentTime;
    }
}
