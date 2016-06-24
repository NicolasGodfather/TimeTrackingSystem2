package com.asinovich.dto;

import com.asinovich.domain.SpentTime;

import java.util.Date;

/**
 *
 * @author Nicolas Asinovich.
 */
public class SpentTimeDTO {

    private String id;
    private EmployeeDTO employeeNameDTO;
    private Date insertDate;
    private String numberOfHour;
    private TaskDTO nameTaskDTO;

    public SpentTimeDTO (SpentTime spentTime) {
        this.id = Long.toString(spentTime.getId());
        this.employeeNameDTO = new EmployeeDTO(spentTime.getEmployeeName());
        this.insertDate = spentTime.getInsertDate();
        this.numberOfHour = Integer.toString(spentTime.getNumberOfHour());
        this.nameTaskDTO = new TaskDTO(spentTime.getNameTask());
    }

    public SpentTimeDTO () {
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public EmployeeDTO getEmployeeNameDTO () {
        return employeeNameDTO;
    }

    public void setEmployeeNameDTO (EmployeeDTO employeeNameDTO) {
        this.employeeNameDTO = employeeNameDTO;
    }

    public Date getInsertDate () {
        return insertDate;
    }

    public void setInsertDate (Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getNumberOfHour () {
        return numberOfHour;
    }

    public void setNumberOfHour (String numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    public TaskDTO getNameTaskDTO () {
        return nameTaskDTO;
    }

    public void setNameTaskDTO (TaskDTO nameTaskDTO) {
        this.nameTaskDTO = nameTaskDTO;
    }

}
