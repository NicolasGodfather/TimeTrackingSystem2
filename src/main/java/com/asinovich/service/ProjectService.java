package com.asinovich.service;

import com.asinovich.dto.ProjectDTO;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public interface ProjectService {

    ProjectDTO getById (long id);

    List<ProjectDTO> getAll();

    void insert(ProjectDTO projectDTO);

    void update(ProjectDTO projectDTO);

    void deleteById(long id);
}
