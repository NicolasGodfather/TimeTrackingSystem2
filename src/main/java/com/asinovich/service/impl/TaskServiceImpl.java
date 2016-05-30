package com.asinovich.service.impl;

import com.asinovich.dao.TaskDAO;
import com.asinovich.dto.TaskDTO;
import com.asinovich.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */

@Service
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDao;


    @Override
    public TaskDTO getById (long id) {
        return null;
    }

    @Override
    public List<TaskDTO> getAll () {
        return null;
    }

    @Override
    public void insert (TaskDTO taskDTO) {

    }

    @Override
    public void update (TaskDTO taskDTO) {

    }

    @Override
    public void deleteById (long id) {

    }
}
