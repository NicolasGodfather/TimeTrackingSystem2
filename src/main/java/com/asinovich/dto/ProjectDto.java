package com.asinovich.dto;

import com.asinovich.domain.Project;

import java.util.List;

/**
 *
 * @author Nicolas Asinovich.
 */
public class ProjectDTO {

    private String id;
    private String projectName;
    private EmployeeDTO responsibleEmployeeDTO;
    private List<TaskDTO> taskDTOs;

    public ProjectDTO () {
    }

    public ProjectDTO (Project project) {
        this.id = Long.toString(project.getId());
        this.projectName = project.getProjectName();
        this.responsibleEmployeeDTO = new EmployeeDTO(project.getResponsibleEmployee());
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

    public EmployeeDTO getResponsibleEmployeeDTO () {
        return responsibleEmployeeDTO;
    }

    public void setResponsibleEmployeeDTO (EmployeeDTO responsibleEmployeeDTO) {
        this.responsibleEmployeeDTO = responsibleEmployeeDTO;
    }

    public List<TaskDTO> getTaskDTOs () {
        return taskDTOs;
    }

    public void setTaskDTOs (List<TaskDTO> taskDTOs) {
        this.taskDTOs = taskDTOs;
    }
}
