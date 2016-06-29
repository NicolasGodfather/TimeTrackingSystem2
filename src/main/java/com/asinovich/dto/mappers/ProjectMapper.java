package com.asinovich.dto.mappers;

import com.asinovich.domain.Project;
import com.asinovich.domain.SpentTime;
import com.asinovich.domain.Task;
import com.asinovich.dto.ProjectDTO;
import com.asinovich.dto.SpentTimeDTO;
import com.asinovich.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeDTOToTheEmployee;
import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeToTheEmployeeDTO;
import static com.asinovich.dto.mappers.TaskMapper.*;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class ProjectMapper {

    /**
     * Convert Project
     */
    public static Project convertProjectDTOToTheProject (ProjectDTO projectDTO) {
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

    private static List<Task> getTaskList (ProjectDTO projectDTO, List<Task> tasks) {
        List<SpentTime> spentTimes = new ArrayList<>();
        Task task = new Task();
        List<TaskDTO> taskDTOs = projectDTO.getTaskDTOs();
        if (projectDTO.getTaskDTOs() != null) {
            for (TaskDTO taskDTO : taskDTOs) {
                if (taskDTO.getId() == null) {
                    setTask(taskDTO, task, spentTimes);
                } else {
                    task.setId(Long.parseLong(taskDTO.getId()));
                    setTask(taskDTO, task, spentTimes);
                }
                tasks.add(convertTaskDTOToTheTask(taskDTO));
            }
        }
        return tasks;
    }

    private static void setProject (ProjectDTO projectDTO, Project project) {
        project.setProjectName(projectDTO.getProjectName());
        project.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(projectDTO.getResponsibleEmployeeDTO()));
    }

    /**
     * Convert ProjectDTO
     */
    public static ProjectDTO convertProjectToTheProjectDTO (Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        List<TaskDTO> taskDTOs = new ArrayList<>();
        getTaskListDTO(project, taskDTOs);
        if (String.valueOf(project.getId()).isEmpty()) {
            setProjectDTO(projectDTO, project);
        } else {
            setProjectDTO(projectDTO, project);
            projectDTO.setId(String.valueOf(projectDTO.getId()));
        }
        return projectDTO;
    }

    private static List<TaskDTO> getTaskListDTO (Project project, List<TaskDTO> taskDTOs) {
        List<SpentTimeDTO> spentTimeDTOs = new ArrayList<>();
        TaskDTO taskDTO = new TaskDTO();
        List<Task> tasks = project.getListTask();
        if (project.getListTask() != null) {
            for (Task task : tasks) {
                if (String.valueOf(task.getId()).isEmpty()) {
                    setTaskDTO(taskDTO, task, spentTimeDTOs);
                } else {
                    task.setId(Long.parseLong(taskDTO.getId()));
                    setTaskDTO(taskDTO, task, spentTimeDTOs);
                }
                taskDTOs.add(convertTaskToTheTaskDTO(task));
            }
        }
        return taskDTOs;
    }

    private static void setProjectDTO (ProjectDTO projectDTO, Project project) {
        projectDTO.setProjectName(project.getProjectName());
        projectDTO.setResponsibleEmployeeDTO(convertEmployeeToTheEmployeeDTO(project.getResponsibleEmployee()));
    }
}
