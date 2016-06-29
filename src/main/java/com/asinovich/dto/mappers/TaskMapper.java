package com.asinovich.dto.mappers;

import com.asinovich.domain.SpentTime;
import com.asinovich.domain.Task;
import com.asinovich.dto.SpentTimeDTO;
import com.asinovich.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeDTOToTheEmployee;
import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeToTheEmployeeDTO;
import static com.asinovich.dto.mappers.SpentTimeMapper.*;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class TaskMapper {

    /**
     * Convert to Task
     */
    public static Task convertTaskDTOToTheTask (TaskDTO taskDTO) {
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

    private static List<SpentTime> getSpentTimeList (TaskDTO taskDTO, List<SpentTime> spentTimes) {
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

    static void setTask (TaskDTO taskDTO, Task task, List<SpentTime> spentTimes) {
        task.setTaskName(taskDTO.getTaskName());
        task.setResponsibleEmployee(convertEmployeeDTOToTheEmployee(taskDTO.getResponsibleEmployee()));
        task.setListSpentTime(spentTimes);
    }

    /**
     * Convert to TaskDTO
     */
    public static TaskDTO convertTaskToTheTaskDTO (Task task) {
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

    private static List<SpentTimeDTO> getSpentTimeListDTO (Task task, List<SpentTimeDTO> spentTimesDTOs) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        List<SpentTime> spentTimes = task.getListSpentTime();
        if (getValueOf(task.getId()).isEmpty()) {
            for (SpentTime spentTime : spentTimes) {
                if (getValueOf(spentTime.getId()).isEmpty()) {
                    setSpentTimeDTO(spentTimeDTO, spentTime);
                } else {
                    spentTimeDTO.setId(getValueOf(spentTime.getId()));
                    setSpentTimeDTO(spentTimeDTO, spentTime);
                }
                spentTimesDTOs.add(convertSpentTimeToSpentTimeDTO(spentTime));
            }
        }
        return spentTimesDTOs;
    }
    static void setTaskDTO (TaskDTO taskDTO, Task task, List<SpentTimeDTO> spentTimesDTOs) {
        taskDTO.setTaskName(task.getTaskName());
        taskDTO.setResponsibleEmployee(convertEmployeeToTheEmployeeDTO(task.getResponsibleEmployee()));
        taskDTO.setSpentTimeDTOs(spentTimesDTOs);
    }

    // TODO: правильно ли я сделал, что вынес это действие, если приходится преобразовать 4 раза в данном классе?
    private static String getValueOf(long x) {
        return String.valueOf(x);
    }
}
