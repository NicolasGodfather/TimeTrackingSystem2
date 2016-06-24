package com.asinovich.dao;

import com.asinovich.domain.SpentTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Реализация поведения Записи Затраченного Времени
 *
 * 3. Вносить записи о затраченном времени.
 * 4. Формировать два отчета:
 * 4.1. Какие записи о затраченном времени были внесены за указанный диапазон дат.
 * 4.2. Сколько суммарно времени затратил каждый разработчик за указанный диапазон дат.
 *
 * @author Nicolas Asinovich.
 */
public interface SpentTimeDAO extends CrudRepository<SpentTime, Long> {

    List<SpentTime> findAll();

    void saveAndFlush(SpentTime spentTime);
}
