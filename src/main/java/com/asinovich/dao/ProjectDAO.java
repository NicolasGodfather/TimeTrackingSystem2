package com.asinovich.dao;

import com.asinovich.domain.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Реализация поведения Проекта
 *
 * @author Nicolas Asinovich.
 */
public interface ProjectDAO extends CrudRepository<Project, Long>{

    Project findOne(Long id);

    List<Project> findAll();

    void saveAndFlush(Project project);

    void delete(Project project);
}
