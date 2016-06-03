package com.asinovich.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Реализация Работника как Сущности
 *
 * Работник содержит следующую информацию:
        1. Имя
        2. Фамилия
        3. Должность
        4. Список проектов
        5. Список задач
 *
 * @author Nicolas Asinovich.
 */

@Entity
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    private String position;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "responsibleEmployee")
    private List<Project> projects;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "responsibleEmployee")
    private List<Task> tasks;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "employeeName")
    private List<RecordSpentTime> recordSpentTimes;

    public Employee () {
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public List<Project> getProjects () {
        return projects;
    }

    public void setProjects (List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks () {
        return tasks;
    }

    public void setTasks (List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<RecordSpentTime> getRecordSpentTimes () {
        return recordSpentTimes;
    }

    public void setRecordSpentTimes (List<RecordSpentTime> recordSpentTimes) {
        this.recordSpentTimes = recordSpentTimes;
    }
}
