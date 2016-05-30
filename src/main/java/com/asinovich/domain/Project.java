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
@Table (name = "project")
public class Project {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "projectName")
    private String projectName;

    @Column (name = "responsibleEmployee")
//    @ManyToMany
    private Employee responsibleEmployee;

    @Column (name = "listTask")
//    @ManyToOne
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
