package com.asinovich.dao;

import com.asinovich.domain.RecordSpentTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Реализация поведения записи затраченного времени
 *
 * 3. Вносить записи о затраченном времени.
 * 4. Формировать два отчета:
 * 4.1. Какие записи о затраченном времени были внесены за указанный диапазон дат.
 * 4.2. Сколько суммарно времени затратил каждый разработчик за указанный диапазон дат.
 *
 * @author Nicolas Asinovich.
 */
public interface RecordSpentTimeDAO extends CrudRepository<RecordSpentTime, Long> {

    RecordSpentTime findOne(Long id);

    List<RecordSpentTime> findAll();

    void saveAndFlush(RecordSpentTime recordSpentTime);

    void delete(RecordSpentTime recordSpentTime);

    RecordSpentTimeDAO insertRecord();

    RecordSpentTimeDAO shapeReport1(int firstDate, int secondDate);

    RecordSpentTimeDAO shapeReport2(int numOfHour);
}
