package com.asinovich.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Реализация Проекта как Сущности
 * Проект содержит следующую информацию:
        1. Название.
        2. Ответственное за проект лицо.
        3. Список задач.
 *
 * @author Nicolas Asinovich.
 */

@Entity
public class Project {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String projectName;

    @ManyToMany
    @JoinColumn(name = "responsibleEmployeeId")
    private Employee responsibleEmployee;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="owner")
    @JoinColumn(name = "responsibleEmployeeId")
    private List<Task> listTask;

    public long getId () {
        return id;
    }

    public void setId (long id) {
        this.id = id;
    }

    public String getProjectName () {
        return projectName;
    }

    public void setProjectName (String projectName) {
        this.projectName = projectName;
    }

    public Employee getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (Employee responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    public List<Task> getListTask () {
        return listTask;
    }

    public void setListTask (List<Task> listTask) {
        this.listTask = listTask;
    }
}
