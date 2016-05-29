package com.asinovich.dto;

import com.asinovich.domain.Project;
import com.asinovich.domain.Task;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class ProjectDto {

    private String id;

    private String projectName;

    private String employeeName;

    private List<Task> listTask;

    public ProjectDto () {
    }

    public ProjectDto (Project project) {
        this.id = Long.toString(project.getId());
        this.projectName = project.getProjectName();
        this.employeeName = project.getEmployeeName();
        this.listTask = project.getListTask();
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getProjectName () {
        return projectName;
    }

    public void setProjectName (String projectName) {
        this.projectName = projectName;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Task> getListTask () {
        return listTask;
    }

    public void setListTask (List<Task> listTask) {
        this.listTask = listTask;
    }
}
