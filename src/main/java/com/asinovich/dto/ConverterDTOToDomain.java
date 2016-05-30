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
 * TODO: тут нужно очень внимательно смотреть и думать, возможно можно сделать по-другому
 * @author Nicolas Asinovich.
 */
@Component
public class ConverterDTOToDomain {

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
     * TODO а именно этот метод, т.к. при преобразовании Project должны преобразовываться Task и RecordSpentTime
     */
    public Project convertProjectDTOToTheProject (ProjectDTO projectDTO) {
        Project project = new Project();
        Task task = new Task();
        List<Task> tasks = new ArrayList<>();
        List<TaskDTO> taskDTOs = projectDTO.getTaskDTOs();
        List<RecordSpentTime> recordSpentTimes = new ArrayList<>();
        if (projectDTO.getTaskDTOs() != null) {
            for (TaskDTO taskDTO : taskDTOs) {
                if (taskDTO.getId() == null) {
                    setTask(taskDTO, task, recordSpentTimes);
                } else {
                    task.setId(Long.parseLong(taskDTO.getId()));
                    setTask(taskDTO, task, recordSpentTimes);
                }
                tasks.add(convertTaskDTOToTheTask(taskDTO));
            }
        }
        if (projectDTO.getId() == null) {
            setProject(projectDTO, project, tasks);
        } else {
            setProject(projectDTO, project, tasks);
            project.setId(Long.parseLong(projectDTO.getId()));
        }
        return project;
    }
    private void setProject (ProjectDTO projectDTO, Project project, List<Task> tasks) {
        project.setProjectName(projectDTO.getProjectName());
        project.setResponsibleEmployee(projectDTO.getResponsibleEmployee());
        project.setListTask(tasks);
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
        task.setResponsibleEmployee(taskDTO.getResponsibleEmployee());
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
        recordSpentTime.setNumberOfHour(recordSpentTimeDTO.getNumberOfHour());
    }
}
