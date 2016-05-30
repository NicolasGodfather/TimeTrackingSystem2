package com.asinovich.dao;

import com.asinovich.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Реализация поведения Задачи
 *
 * @author Nicolas Asinovich.
 */
public interface TaskDAO extends CrudRepository<Task, Long> {

    Task findOne(Long id);

    List<Task> findAll();

    void saveAndFlush(Task task);

    void delete(Task task);
}
