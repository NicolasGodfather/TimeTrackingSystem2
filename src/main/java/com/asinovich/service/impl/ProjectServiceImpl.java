package com.asinovich.service.impl;

import com.asinovich.dao.ProjectDAO;
import com.asinovich.domain.Project;
import com.asinovich.dto.ConverterDTOToDomain;
import com.asinovich.dto.ProjectDTO;
import com.asinovich.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Override
    public ProjectDTO getById (long id) {
        return new ProjectDTO(projectDAO.findOne(id));
    }

    @Override
    public List<ProjectDTO> getAll () {
        List<Project> projects = projectDAO.findAll();
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        for (Project project : projects) {
            projectDTOs.add(new ProjectDTO(project));
        }
        return projectDTOs;
    }

    @Override
    public void insert (ProjectDTO projectDTO) {

    }

    @Override
    public void update (ProjectDTO projectDTO) {

    }

    @Override
    public void deleteById (long id) {

    }
}
