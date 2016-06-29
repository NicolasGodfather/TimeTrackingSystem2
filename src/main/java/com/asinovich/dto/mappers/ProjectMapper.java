package com.asinovich.dto.mappers;

import com.asinovich.domain.Project;
import com.asinovich.domain.SpentTime;
import com.asinovich.domain.Task;
import com.asinovich.dto.ProjectDTO;
import com.asinovich.dto.SpentTimeDTO;
import com.asinovich.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class ProjectMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TaskMapper taskMapper;
    /**
     * Convert Project
     */
    public Project convertProjectDTOToTheProject (ProjectDTO projectDTO) {
        Project project = new Project();
        List<Task> tasks = new ArrayList<>();
        getTaskList(projectDTO, tasks);
        if (projectDTO.getId() == null) {
            setProject(projectDTO, project);
        } else {
            setProject(projectDTO, project);
            project.setId(Long.parseLong(projectDTO.getId()));
        }
        return project;
    }

    private List<Task> getTaskList (ProjectDTO projectDTO, List<Task> tasks) {
        List<SpentTime> spentTimes = new ArrayList<>();
        Task task = new Task();
        List<TaskDTO> taskDTOs = projectDTO.getTaskDTOs();
        if (projectDTO.getTaskDTOs() != null) {
            for (TaskDTO taskDTO : taskDTOs) {
                if (taskDTO.getId() == null) {
                    taskMapper.setTask(taskDTO, task, spentTimes);
                } else {
                    task.setId(Long.parseLong(taskDTO.getId()));
                    taskMapper.setTask(taskDTO, task, spentTimes);
                }
                tasks.add(taskMapper.convertTaskDTOToTheTask(taskDTO));
            }
        }
        return tasks;
    }

    private void setProject (ProjectDTO projectDTO, Project project) {
        project.setProjectName(projectDTO.getProjectName());
        project.setResponsibleEmployee(employeeMapper.
                convertEmployeeDTOToTheEmployee(projectDTO.getResponsibleEmployeeDTO()));
    }

    /**
     * Convert ProjectDTO
     */
    public ProjectDTO convertProjectToTheProjectDTO (Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        List<TaskDTO> taskDTOs = new ArrayList<>();
        getTaskListDTO(project, taskDTOs);
        if (getValueOf(project.getId()).isEmpty()) {
            setProjectDTO(projectDTO, project);
        } else {
            projectDTO.setId(getValueOf(project.getId()));
            setProjectDTO(projectDTO, project);
        }
        return projectDTO;
    }

    private List<TaskDTO> getTaskListDTO (Project project, List<TaskDTO> taskDTOs) {
        List<SpentTimeDTO> spentTimeDTOs = new ArrayList<>();
        TaskDTO taskDTO = new TaskDTO();
        List<Task> tasks = project.getListTask();
        if (project.getListTask() != null) {
            for (Task task : tasks) {
                if (getValueOf(task.getId()).isEmpty()) {
                    taskMapper.setTaskDTO(taskDTO, task, spentTimeDTOs);
                } else {
                    taskDTO.setId(getValueOf(task.getId()));
                    taskMapper.setTaskDTO(taskDTO, task, spentTimeDTOs);
                }
                taskDTOs.add(taskMapper.convertTaskToTheTaskDTO(task));
            }
        }
        return taskDTOs;
    }

    private void setProjectDTO (ProjectDTO projectDTO, Project project) {
        projectDTO.setProjectName(project.getProjectName());
        projectDTO.setResponsibleEmployeeDTO(employeeMapper.
                convertEmployeeToTheEmployeeDTO(project.getResponsibleEmployee()));
    }

    private String getValueOf(long x) {
        return String.valueOf(x);
    }
}
