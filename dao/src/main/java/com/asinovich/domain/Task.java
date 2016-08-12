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
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String taskName;

    @OneToOne
    @JoinColumn(name = "responsibleEmployeeId")
    private Employee responsibleEmployee;

    @ManyToOne
    @JoinColumn(name = "taskOfProjectId")
    private Project taskOfProject;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "nameTask")
    private List<SpentTime> listSpentTime;

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

    public Employee getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (Employee responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public Project getTaskOfProject () {
        return taskOfProject;
    }

    public void setTaskOfProject (Project taskOfProject) {
        this.taskOfProject = taskOfProject;
    }

    public List<SpentTime> getListSpentTime () {
        return listSpentTime;
    }

    public void setListSpentTime (List<SpentTime> listSpentTime) {
        this.listSpentTime = listSpentTime;
    }
}
