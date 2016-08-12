package com.asinovich.service.impl;

import com.asinovich.dao.TaskDAO;
import com.asinovich.domain.Task;
import com.asinovich.dto.TaskDTO;
import com.asinovich.dto.mappers.TaskMapper;
import com.asinovich.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas Asinovich.
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    @Transactional (readOnly = true)
    public TaskDTO getById (long id) {
        return taskMapper.convertTaskToTaskDTO(taskDAO.findOne(id));
    }

    @Override
    @Transactional (readOnly = true)
    public List<TaskDTO> getAll () {
        List<Task> tasks = taskDAO.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<TaskDTO>();
        for (Task task : tasks) {
            taskDTOs.add(taskMapper.convertTaskToTaskDTO(task));
        }
        return taskDTOs;
    }

    @Override
    @Transactional
    public void insert (TaskDTO taskDTO) {
        taskDAO.saveAndFlush(taskMapper.convertTaskDTOToTask(taskDTO));
    }

    @Override
    @Transactional
    public void update (TaskDTO taskDTO) {
        taskDAO.saveAndFlush(taskMapper.convertTaskDTOToTask(taskDTO));
    }

    @Override
    @Transactional
    public void deleteById (long id) {
        Task task = taskDAO.findOne(id);
        taskDAO.deleted(task);
    }
}
