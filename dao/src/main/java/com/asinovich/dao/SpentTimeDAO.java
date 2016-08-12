package com.asinovich.dao;

import com.asinovich.domain.SpentTime;

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
public interface SpentTimeDAO extends AbstractCrud<SpentTime, Long> {

}
