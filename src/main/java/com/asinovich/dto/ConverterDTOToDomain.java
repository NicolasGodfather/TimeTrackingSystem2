package com.asinovich.dto;

import com.asinovich.domain.Employee;
import com.asinovich.domain.Project;
import com.asinovich.domain.RecordSpentTime;
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

    public Employee convertEmployeeDTOToTheEmployee(EmployeeDTO employeeDTO) {
        return getEmployee(employeeDTO);
    }
    private Employee getEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        List<Project> projects = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();

        getProjectList(employeeDTO, projects);
        getTaskList(employeeDTO, tasks);
        if (employeeDTO.getId() == null) {
            setEmployee(employeeDTO, employee, projects, tasks);
        } else {
            employee.setId(Long.parseLong(employeeDTO.getId()));
            setEmployee(employeeDTO, employee, projects, tasks);
        }
        return employee;
    }
    private List<Project> getProjectList (EmployeeDTO employeeDTO, List<Project> projects) {
        Project project = new Project();
        List<ProjectDTO> projectDTOs = employeeDTO.getProjectDTOs();
        if (employeeDTO.getProjectDTOs() != null) {
            for (ProjectDTO projectDTO : projectDTOs) {
                if (projectDTO.getId() == null) {
                    setProject(projectDTO, project);
                } else {
                    project.setId(Long.parseLong(projectDTO.getId()));
                    setProject(projectDTO, project);
                }
                projects.add(convertProjectDTOToTheProject(projectDTO));
            }
        }
        return projects;
    }
    private List<Task> getTaskList (EmployeeDTO employeeDTO, List<Task> tasks) {
        List<RecordSpentTime> recordSpentTimes = new ArrayList<>();
        Task task = new Task();
        List<TaskDTO> taskDTOs = employeeDTO.getTaskDTOs();
        if (employeeDTO.getTaskDTOs() != null) {
            for (TaskDTO taskDTO : taskDTOs) {
                if (taskDTO.getId() == null) {
                    setTask(taskDTO, task, recordSpentTimes);
                } else {
                    task.setId(Long.parseLong(taskDTO.getId()));
                    setTask(taskDTO, task, recordSpentTimes);
                }
            }
        }
        return tasks;
    }
    private void setEmployee (EmployeeDTO employeeDTO, Employee employee,
                              List<Project> projects, List<Task> tasks) {
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setPosition(employeeDTO.getPosition());
        employee.setProjects(projects);
        employee.setTasks(tasks);
    }

    public Project convertProjectDTOToTheProject (ProjectDTO projectDTO) {
        Project project = new Project();
        if (projectDTO.getId() == null) {
            setProject(projectDTO, project);
        } else {
            setProject(projectDTO, project);
            project.setId(Long.parseLong(projectDTO.getId()));
        }
        return project;
    }
    private void setProject (ProjectDTO projectDTO, Project project) {
        project.setProjectName(projectDTO.getProjectName());
        project.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(projectDTO.getResponsibleEmployeeDTO()));
    }

    public Task convertTaskDTOToTheTask (TaskDTO taskDTO) {
        Task task = new Task();
        RecordSpentTime recordSpentTime = new RecordSpentTime();
        List<RecordSpentTime> recordSpentTimes = new ArrayList<>();
        List<RecordSpentTimeDTO> recordSpentTimeDTOs = taskDTO.getRecordSpentTimeDTOs();
        if (taskDTO.getId() != null) {
            for (RecordSpentTimeDTO recordSpentTimeDTO : recordSpentTimeDTOs) {
                if (recordSpentTimeDTO.getId() == null) {
                    setRecordSpentTime(recordSpentTimeDTO, recordSpentTime);
                } else {
                    recordSpentTime.setId(Long.parseLong(recordSpentTimeDTO.getId()));
                    setRecordSpentTime(recordSpentTimeDTO, recordSpentTime);
                }
                recordSpentTimes.add(convertRecordSpentTimeDTOToTheRecordSpentTime(recordSpentTimeDTO));
            }
        }
        if (taskDTO.getId() == null) {
            setTask(taskDTO, task, recordSpentTimes);
        } else {
            setTask(taskDTO, task, recordSpentTimes);
            task.setId(Long.parseLong(taskDTO.getId()));
        }
        return task;
    }

    private void setTask (TaskDTO taskDTO, Task task, List<RecordSpentTime> recordSpentTimes) {
        task.setTaskName(taskDTO.getTaskName());
        task.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(taskDTO.getResponsibleEmployee()));
        task.setListRecordSpentTime(recordSpentTimes);
    }

    public RecordSpentTime convertRecordSpentTimeDTOToTheRecordSpentTime (RecordSpentTimeDTO recordSpentTimeDTO) {
        RecordSpentTime recordSpentTime = new RecordSpentTime();
        if (recordSpentTimeDTO.getId() == null) {
            setRecordSpentTime(recordSpentTimeDTO, recordSpentTime);
        } else {
            recordSpentTime.setId(Long.parseLong(recordSpentTimeDTO.getId()));
            setRecordSpentTime(recordSpentTimeDTO, recordSpentTime);
        }
        return recordSpentTime;
    }
    private void setRecordSpentTime (RecordSpentTimeDTO recordSpentTimeDTO, RecordSpentTime recordSpentTime) {
        recordSpentTime.setEmployeeName(recordSpentTimeDTO.getEmployeeName());
        recordSpentTime.setCalendarInsertRecord(recordSpentTimeDTO.getCalendarInsertRecord());
        recordSpentTime.setNumberOfHour(new Integer(recordSpentTimeDTO.getNumberOfHour()));
    }
}
