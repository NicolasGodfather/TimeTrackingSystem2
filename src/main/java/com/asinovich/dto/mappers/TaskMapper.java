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
    public Task convertTaskDTOToTheTask (TaskDTO taskDTO) {
        Task task = new Task();
        List<SpentTime> spentTimes = new ArrayList<>();
        getSpentTimeList(taskDTO, spentTimes);
        if (taskDTO.getId() == null) {
            setTask(taskDTO, task, spentTimes);
        } else {
            task.setId(Long.parseLong(taskDTO.getId()));
            setTask(taskDTO, task, spentTimes);
        }
        return task;
    }

    private List<SpentTime> getSpentTimeList (TaskDTO taskDTO, List<SpentTime> spentTimes) {
        SpentTime spentTime = new SpentTime();
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

    void setTask (TaskDTO taskDTO, Task task, List<SpentTime> spentTimes) {
        task.setTaskName(taskDTO.getTaskName());
        task.setResponsibleEmployee(employeeMapper.convertEmployeeDTOToTheEmployee(taskDTO.getResponsibleEmployee()));
        task.setListSpentTime(spentTimes);
    }

    /**
     * Convert to TaskDTO
     */
    public TaskDTO convertTaskToTheTaskDTO (Task task) {
        TaskDTO taskDTO = new TaskDTO();
        List<SpentTimeDTO> spentTimesDTOs = new ArrayList<>();
        getSpentTimeListDTO(task, spentTimesDTOs);
        if (task.getId() == 0) {
            setTaskDTO(taskDTO, task, spentTimesDTOs);
        } else {
            taskDTO.setId(getValueOf(task.getId()));
            setTaskDTO(taskDTO, task, spentTimesDTOs);
        }
        return taskDTO;
    }

    private List<SpentTimeDTO> getSpentTimeListDTO (Task task, List<SpentTimeDTO> spentTimesDTOs) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
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
    void setTaskDTO (TaskDTO taskDTO, Task task, List<SpentTimeDTO> spentTimesDTOs) {
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setResponsibleEmployee(employeeMapper.convertEmployeeToTheEmployeeDTO(task.getResponsibleEmployee()));
        taskDTO.setSpentTimeDTOs(spentTimesDTOs);
    }

    // TODO: правильно ли я сделал, что вынес это действие, если приходится преобразовать 4 раза в данном классе?
    private String getValueOf(long x) {
        return String.valueOf(x);
    }
}
