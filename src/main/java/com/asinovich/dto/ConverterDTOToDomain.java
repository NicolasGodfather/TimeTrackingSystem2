package com.asinovich.dto;

import com.asinovich.domain.Employee;
import com.asinovich.domain.Project;
import com.asinovich.domain.SpentTime;
import com.asinovich.domain.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация преобразования из одного слоя в другой
 *
 * TODO: all need to make it easier =)
 * @author Nicolas Asinovich.
 */
@Component
public class ConverterDTOToDomain {
    /**
     * Convert Employee
     */
    public Employee convertEmployeeDTOToTheEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        if (employeeDTO.getId() == null) {
            setEmployee(employeeDTO, employee);
        } else {
            employee.setId(Long.parseLong(employeeDTO.getId()));
            setEmployee(employeeDTO, employee);
        }
        return employee;
    }

    private void setEmployee (EmployeeDTO employeeDTO, Employee employee) {
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setPosition(employeeDTO.getPosition());
    }


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

    private void setProject (ProjectDTO projectDTO, Project project) {
        project.setProjectName(projectDTO.getProjectName());
        project.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(projectDTO.getResponsibleEmployeeDTO()));
    }

    /**
     * Convert Task
     */
    public Task convertTaskDTOToTheTask (TaskDTO taskDTO) {
        Task task = new Task();
        List<SpentTime> spentTimes = new ArrayList<>();
        getSpentTimeList(taskDTO, spentTimes);
        if (taskDTO.getId() == null) {
            setTask(taskDTO, task, spentTimes);
        } else {
            setTask(taskDTO, task, spentTimes);
            task.setId(Long.parseLong(taskDTO.getId()));
        }
        return task;
    }

    private List<SpentTime> getSpentTimeList
            (TaskDTO taskDTO,List<SpentTime> spentTimes) {
        SpentTime spentTime = new SpentTime();
        List<SpentTimeDTO> spentTimeDTOs = taskDTO.getSpentTimeDTOs();
        if (taskDTO.getId() != null) {
            for (SpentTimeDTO spentTimeDTO : spentTimeDTOs) {
                if (spentTimeDTO.getId() == null) {
                    setSpentTime(spentTimeDTO, spentTime);
                } else {
                    spentTime.setId(Long.parseLong(spentTimeDTO.getId()));
                    setSpentTime(spentTimeDTO, spentTime);
                }
                spentTimes.add(convertSpentTimeDTOToSpentTime(spentTimeDTO));
            }
        }
        return spentTimes;
    }

    private void setTask (TaskDTO taskDTO, Task task, List<SpentTime> spentTimes) {
        task.setTaskName(taskDTO.getTaskName());
        task.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(taskDTO.getResponsibleEmployee()));
        task.setListSpentTime(spentTimes);
    }

    /**
     * Convert SpentTime
     */
    public SpentTime convertSpentTimeDTOToSpentTime (SpentTimeDTO spentTimeDTO) {
        SpentTime spentTime = new SpentTime();
        if (spentTimeDTO.getId() == null) {
            setSpentTime(spentTimeDTO, spentTime);
        } else {
            spentTime.setId(Long.parseLong(spentTimeDTO.getId()));
            setSpentTime(spentTimeDTO, spentTime);
        }
        return spentTime;
    }
    private void setSpentTime (SpentTimeDTO spentTimeDTO, SpentTime spentTime) {
        spentTime.setEmployeeName(convertEmployeeDTOToTheEmployee(spentTimeDTO.getEmployeeNameDTO()));
        spentTime.setInsertDate(spentTimeDTO.getInsertDate());
        spentTime.setNumberOfHour(new Integer(spentTimeDTO.getNumberOfHour()));
    }
}
