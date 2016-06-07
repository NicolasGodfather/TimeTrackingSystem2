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

    @ManyToOne
    @JoinColumn(name = "responsibleEmployeeId")
    private Employee responsibleEmployee;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "taskOfProject")
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
