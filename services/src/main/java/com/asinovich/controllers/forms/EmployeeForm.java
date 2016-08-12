package com.asinovich.controllers.forms;

import com.asinovich.dto.EmployeeDTO;

/**
 *
 * @author Nicolas Asinovich.
 */
public class EmployeeForm {

    private String id;
    private String name;
    private String surname;
    private String position;

    public EmployeeForm () {
    }

    public EmployeeForm (EmployeeDTO employeeDTO) {
        this.id = employeeDTO.getId();
        this.name = employeeDTO.getName();
        this.surname = employeeDTO.getSurname();
        this.position = employeeDTO.getPosition();
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    @Override
    public String toString () {
        return "EmployeeForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
