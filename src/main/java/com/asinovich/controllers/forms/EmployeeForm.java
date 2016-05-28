package com.asinovich.controllers.forms;

import com.asinovich.dto.EmployeeDTO;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class EmployeeForm {
    private String id;
    private String firstName;
    private String lastName;
    private String position;

    public EmployeeForm () {
    }

    public EmployeeForm (EmployeeDTO employeeDTO) {
        this.id = employeeDTO.getId();
        this.firstName =employeeDTO.getFirstName();
        this.lastName = employeeDTO.getLastName();
        this.position = employeeDTO.getPosition();
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
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
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
