package com.asinovich.service;

import com.asinovich.dto.SpentTimeDTO;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public interface SpentTimeService {

    SpentTimeDTO getById (long id);

    List<SpentTimeDTO> getAll();

    void insert(SpentTimeDTO spentTimeDTO);

    void update(SpentTimeDTO spentTimeDTO);

    void deleteById(long id);
}
