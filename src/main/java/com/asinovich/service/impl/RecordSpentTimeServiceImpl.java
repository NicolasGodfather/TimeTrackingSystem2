package com.asinovich.service.impl;

import com.asinovich.dao.RecordSpentTimeDAO;
import com.asinovich.domain.RecordSpentTime;
import com.asinovich.dto.ConverterDTOToDomain;
import com.asinovich.dto.RecordSpentTimeDTO;
import com.asinovich.service.RecordSpentTimeService;
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
public class RecordSpentTimeServiceImpl implements RecordSpentTimeService {

    @Autowired
    private RecordSpentTimeDAO recordSpentTimeDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Override
    @Transactional (readOnly = true)
    public RecordSpentTimeDTO getById (long id) {
        return new RecordSpentTimeDTO(recordSpentTimeDAO.findOne(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecordSpentTimeDTO> getAll () {
        List<RecordSpentTime> recordSpentTimes = recordSpentTimeDAO.findAll();
        List<RecordSpentTimeDTO> recordSpentTimeDTOs = new ArrayList<>();
        for (RecordSpentTime recordSpentTime : recordSpentTimes) {
            recordSpentTimeDTOs.add(new RecordSpentTimeDTO(recordSpentTime));
        }
        return recordSpentTimeDTOs;
    }

    @Override
    @Transactional
    public void insert (RecordSpentTimeDTO recordSpentTimeDTO) {
        recordSpentTimeDAO.saveAndFlush(converterDTOToDomain.
                convertRecordSpentTimeDTOToTheRecordSpentTime(recordSpentTimeDTO));
    }

    @Override
    @Transactional
    public void update (RecordSpentTimeDTO recordSpentTimeDTO) {
        recordSpentTimeDAO.saveAndFlush(converterDTOToDomain.
                convertRecordSpentTimeDTOToTheRecordSpentTime(recordSpentTimeDTO));

    }

    @Override
    @Transactional
    public void deleteById (long id) {
        RecordSpentTime recordSpentTime = recordSpentTimeDAO.findOne(id);
        recordSpentTimeDAO.delete(recordSpentTime);
    }
}
