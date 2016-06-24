package com.asinovich.service.impl;

import com.asinovich.dao.SpentTimeDAO;
import com.asinovich.domain.SpentTime;
import com.asinovich.dto.ConverterDTOToDomain;
import com.asinovich.dto.SpentTimeDTO;
import com.asinovich.service.SpentTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO : still not finish
 *
 * @author Nicolas Asinovich.
 */

@Service
public class SpentTimeServiceImpl implements SpentTimeService {

    @Autowired
    private SpentTimeDAO spentTimeDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Override
    @Transactional (readOnly = true)
    public SpentTimeDTO getById (long id) {
        return new SpentTimeDTO(spentTimeDAO.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SpentTimeDTO> getAll () {
        List<SpentTime> spentTimes = spentTimeDAO.findAll();
        List<SpentTimeDTO> spentTimeDTOs = new ArrayList<>();
        for (SpentTime spentTime : spentTimes) {
            spentTimeDTOs.add(new SpentTimeDTO(spentTime));
        }
        return spentTimeDTOs;
    }

    @Override
    @Transactional
    public void insert (SpentTimeDTO spentTimeDTO) {
        spentTimeDAO.saveAndFlush(converterDTOToDomain.
                convertSpentTimeDTOToSpentTime(spentTimeDTO));
    }

    @Override
    @Transactional
    public void update (SpentTimeDTO spentTimeDTO) {
        spentTimeDAO.saveAndFlush(converterDTOToDomain.
                convertSpentTimeDTOToSpentTime(spentTimeDTO));

    }

    @Override
    @Transactional
    public void deleteById (long id) {
        SpentTime spentTime = spentTimeDAO.findOne(id);
        spentTimeDAO.delete(spentTime);
    }
}
