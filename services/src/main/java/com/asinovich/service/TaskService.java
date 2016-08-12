package com.asinovich.service;

import com.asinovich.dto.TaskDTO;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public interface TaskService {

    TaskDTO getById (long id);

    List<TaskDTO> getAll();

    void insert(TaskDTO taskDTO);

    void update(TaskDTO taskDTO);

    void deleteById(long id);
}
