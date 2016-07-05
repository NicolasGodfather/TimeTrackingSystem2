package com.asinovich.dto.mappers;

import com.asinovich.domain.SpentTime;
import com.asinovich.domain.Task;
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
public class TaskMapper {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SpentTimeMapper spentTimeMappers;

    /**
     * Convert to Task
     */
    public Task convertTaskDTOToTask (TaskDTO taskDTO) {
        Task task = new Task();
        getSpentTimeList(taskDTO);
        if (taskDTO.getId() == null) {
            setTask(taskDTO, task);
        } else {
            task.setId(Long.parseLong(taskDTO.getId()));
            setTask(taskDTO, task);
        }
        return task;
    }

    private List<SpentTime> getSpentTimeList (TaskDTO taskDTO) {
        SpentTime spentTime = new SpentTime();
        List<SpentTime> spentTimes = new ArrayList<>();
        List<SpentTimeDTO> spentTimeDTOs = taskDTO.getSpentTimeDTOs();
        if (taskDTO.getId() != null) {
            for (SpentTimeDTO spentTimeDTO : spentTimeDTOs) {
                if (spentTimeDTO.getId() == null) {
                    spentTimeMappers.setSpentTime(spentTimeDTO, spentTime);
                } else {
                    spentTime.setId(Long.parseLong(spentTimeDTO.getId()));
                    spentTimeMappers.setSpentTime(spentTimeDTO, spentTime);
                }
                spentTimes.add(spentTimeMappers.convertSpentTimeDTOToSpentTime(spentTimeDTO));
            }
        }
        return spentTimes;
    }

    void setTask (TaskDTO taskDTO, Task task) {
        List<SpentTime> spentTimes = new ArrayList<>();
        task.setTaskName(taskDTO.getTaskName());
        task.setResponsibleEmployee(employeeMapper.convertEmployeeDTOToEmployee(taskDTO.getResponsibleEmployee()));
        task.setListSpentTime(spentTimes);
    }

    /**
     * Convert to TaskDTO
     */
    public TaskDTO convertTaskToTaskDTO (Task task) {
        TaskDTO taskDTO = new TaskDTO();
        getSpentTimeListDTO(task);
        if (task.getId() == 0) {
            setTaskDTO(taskDTO, task);
        } else {
            taskDTO.setId(getValueOf(task.getId()));
            setTaskDTO(taskDTO, task);
        }
        return taskDTO;
    }

    private List<SpentTimeDTO> getSpentTimeListDTO (Task task) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        List<SpentTimeDTO> spentTimesDTOs = new ArrayList<>();
        List<SpentTime> spentTimes = task.getListSpentTime();
        if (getValueOf(task.getId()).isEmpty()) {
            for (SpentTime spentTime : spentTimes) {
                if (getValueOf(spentTime.getId()).isEmpty()) {
                    spentTimeMappers.setSpentTimeDTO(spentTimeDTO, spentTime);
                } else {
                    spentTimeDTO.setId(getValueOf(spentTime.getId()));
                    spentTimeMappers.setSpentTimeDTO(spentTimeDTO, spentTime);
                }
                spentTimesDTOs.add(spentTimeMappers.convertSpentTimeToSpentTimeDTO(spentTime));
            }
        }
        return spentTimesDTOs;
    }
    void setTaskDTO (TaskDTO taskDTO, Task task) {
        List<SpentTimeDTO> spentTimesDTOs = new ArrayList<>();
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setResponsibleEmployee(employeeMapper.convertEmployeeToTheEmployeeDTO(task.getResponsibleEmployee()));
        taskDTO.setSpentTimeDTOs(spentTimesDTOs);
    }

    // TODO: правильно ли я сделал, что вынес это действие, если приходится преобразовать 4 раза в данном классе?
    private String getValueOf(long x) {
        return String.valueOf(x);
    }
}