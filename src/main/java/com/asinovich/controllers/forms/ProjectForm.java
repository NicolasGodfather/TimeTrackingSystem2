package com.asinovich.controllers.forms;

import com.asinovich.dto.ProjectDTO;

/**
 *
 * @author Nicolas Asinovich.
 */
public class ProjectForm {

    private String id;
    private String projectName;
    private String responsibleEmployee;

    public ProjectForm () {
    }

    public ProjectForm (ProjectDTO projectDTO) {
        this.id = projectDTO.getId();
        this.projectName = projectDTO.getProjectName();
        this.responsibleEmployee = projectDTO.getResponsibleEmployeeDTO().getId();
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

    public String getResponsibleEmployee () {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee (String responsibleEmployee) {
        this.responsibleEmployee = responsibleEmployee;
    }

    @Override
    public String toString () {
        return "ProjectForm{" +
                "projectName='" + projectName + '\'' +
                ", responsibleEmployee='" + responsibleEmployee + '\'' +
                '}';
    }
}
