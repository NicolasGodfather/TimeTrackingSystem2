package com.asinovich.dto.mappers;

import com.asinovich.domain.SpentTime;
import com.asinovich.dto.SpentTimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Nicolas Asinovich.
 */
@Component
public class SpentTimeMapper {

    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * Convert to SpentTime
     */
    public SpentTime convertSpentTimeDTOToSpentTime (SpentTimeDTO spentTimeDTO) {
        SpentTime spentTime = new SpentTime();
        if (spentTimeDTO.getId() == null) {
            setSpentTime(spentTimeDTO, spentTime);
        } else {
            spentTime.setId(Long.parseLong(spentTimeDTO.getId()));
            setSpentTime(spentTimeDTO, spentTime);
        }
        return spentTime;
    }

    void setSpentTime (SpentTimeDTO spentTimeDTO, SpentTime spentTime) {
        spentTime.setEmployeeName(employeeMapper.convertEmployeeDTOToEmployee(spentTimeDTO.getEmployeeNameDTO()));
        spentTime.setInsertDate(spentTimeDTO.getInsertDate());
        spentTime.setNumberOfHour(new Integer(spentTimeDTO.getNumberOfHour()));
    }

    /**
     * Convert to SpentTimeDTO
     */
    public SpentTimeDTO convertSpentTimeToSpentTimeDTO (SpentTime spentTime) {
        SpentTimeDTO spentTimeDTO = new SpentTimeDTO();
        if (getValueOf(spentTime.getId()).isEmpty()) {
            setSpentTimeDTO(spentTimeDTO, spentTime);
        } else {
            spentTimeDTO.setId(getValueOf(spentTime.getId()));
            setSpentTimeDTO(spentTimeDTO, spentTime);
        }
        return spentTimeDTO;
    }

    void setSpentTimeDTO (SpentTimeDTO spentTimeDTO, SpentTime spentTime) {
        spentTimeDTO.setEmployeeNameDTO(employeeMapper.convertEmployeeToTheEmployeeDTO(spentTime.getEmployeeName()));
        spentTimeDTO.setInsertDate(spentTimeDTO.getInsertDate());
        spentTimeDTO.setNumberOfHour(getValueOf(spentTime.getNumberOfHour()));
    }

    // TODO: правильно ли я сделал, что вынес это действие, если приходится преобразовать 3 раза в данном классе?
    private String getValueOf(long x) {
        return String.valueOf(x);
    }
}
