package com.asinovich.service;

import com.asinovich.dto.RecordSpentTimeDTO;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public interface RecordSpentTimeService {

    RecordSpentTimeDTO getById (long id);

    List<RecordSpentTimeDTO> getAll();

    void insert(RecordSpentTimeDTO recordSpentTimeDTO);

    void update(RecordSpentTimeDTO recordSpentTimeDTO);

    void deleteById(long id);
}
