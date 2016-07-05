package com.asinovich.service.impl;

import com.asinovich.dao.ProjectDAO;
import com.asinovich.domain.Project;
import com.asinovich.dto.ProjectDTO;
import com.asinovich.dto.mappers.ProjectMapper;
import com.asinovich.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    @Transactional (readOnly = true)
    public ProjectDTO getById (long id) {
        return projectMapper.convertProjectToProjectDTO(projectDAO.findOne(id));
    }

    @Override
    @Transactional (readOnly = true)
    public List<ProjectDTO> getAll () {
        List<Project> projects = projectDAO.findAll();
        List<ProjectDTO> projectDTOs = new ArrayList<>();
        for (Project project : projects) {
            projectDTOs.add(projectMapper.convertProjectToProjectDTO(project));
        }
        return projectDTOs;
    }

    @Override
    @Transactional
    public void insert (ProjectDTO projectDTO) {
        projectDAO.saveAndFlush(projectMapper.convertProjectDTOToProject(projectDTO));
    }

    @Override
    @Transactional
    public void update (ProjectDTO projectDTO) {
        projectDAO.saveAndFlush(projectMapper.convertProjectDTOToProject(projectDTO));
    }

    @Override
    @Transactional
    public void deleteById (long id) {
        Project project = projectDAO.findOne(id);
        projectDAO.delete(project);
    }
}
