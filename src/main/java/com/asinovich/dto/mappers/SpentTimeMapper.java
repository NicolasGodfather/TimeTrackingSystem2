package com.asinovich.dto.mappers;

import com.asinovich.domain.SpentTime;
import com.asinovich.dto.SpentTimeDTO;
import org.springframework.stereotype.Component;

import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeDTOToTheEmployee;
import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeToTheEmployeeDTO;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class SpentTimeMapper {

    /**
     * Convert to SpentTime
     */
    public static SpentTime convertSpentTimeDTOToSpentTime (SpentTimeDTO spentTimeDTO) {
        SpentTime spentTime = new SpentTime();
        if (spentTimeDTO.getId() == null) {
            setSpentTime(spentTimeDTO, spentTime);
        } else {
            spentTime.setId(Long.parseLong(spentTimeDTO.getId()));
            setSpentTime(spentTimeDTO, spentTime);
        }
        return spentTime;
    }

    static void setSpentTime (SpentTimeDTO spentTimeDTO, SpentTime spentTime) {
        spentTime.setEmployeeName(convertEmployeeDTOToTheEmployee(spentTimeDTO.getEmployeeNameDTO()));
        spentTime.setInsertDate(spentTimeDTO.getInsertDate());
        spentTime.setNumberOfHour(new Integer(spentTimeDTO.getNumberOfHour()));
    }

    /**
     * Convert to SpentTimeDTO
     */
    public static SpentTimeDTO convertSpentTimeToSpentTimeDTO (SpentTime spentTime) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        if (getValueOf(spentTime.getId()).isEmpty()) {
            setSpentTimeDTO(spentTimeDTO, spentTime);
        } else {
            spentTimeDTO.setId(getValueOf(spentTime.getId()));
            setSpentTimeDTO(spentTimeDTO, spentTime);
        }
        return spentTimeDTO;
    }

    static void setSpentTimeDTO (SpentTimeDTO spentTimeDTO, SpentTime spentTime) {
        spentTimeDTO.setEmployeeNameDTO(convertEmployeeToTheEmployeeDTO(spentTime.getEmployeeName()));
        spentTimeDTO.setInsertDate(spentTimeDTO.getInsertDate());
        spentTimeDTO.setNumberOfHour(getValueOf(spentTime.getNumberOfHour()));
    }

    // TODO: правильно ли я сделал, что вынес это действие, если приходится преобразовать 3 раза в данном классе?
    private static String getValueOf(long x) {
        return String.valueOf(x);
    }
}
