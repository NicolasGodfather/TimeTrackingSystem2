package com.asinovich.controllers.forms;

import com.asinovich.dto.SpentTimeDTO;

/**
 *
 * @author Nicolas Asinovich.
 */
public class SpentTimeForm {

    private String id;
    private String employeeName;
    private String insertDate;
    private String numberOfHour;

    public SpentTimeForm () {
    }

    public SpentTimeForm (SpentTimeDTO spentTimeDTO) {
        this.id = spentTimeDTO.getId();
        this.employeeName = spentTimeDTO.getEmployeeNameDTO().getId();
        this.insertDate = String.valueOf(spentTimeDTO.getInsertDate());
        this.numberOfHour = String.valueOf(spentTimeDTO.getNumberOfHour());
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public String getInsertDate () {
        return insertDate;
    }

    public void setInsertDate (String insertDate) {
        this.insertDate = insertDate;
    }

    public String getNumberOfHour () {
        return numberOfHour;
    }

    public void setNumberOfHour (String numberOfHour) {
        this.numberOfHour = numberOfHour;
    }

    @Override
    public String toString () {
        return "SpentTimeForm{" +
                "id='" + id + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", insertDate='" + insertDate + '\'' +
                ", numberOfHour='" + numberOfHour + '\'' +
                '}';
    }
}
