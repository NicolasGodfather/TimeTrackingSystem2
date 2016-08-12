package com.asinovich.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
interface AbstractCrud<T, Long>{

    List<T> findAll();

    T findOne(Long id);

    void saveAndFlush(T t);

    void deleted(T t);
}
