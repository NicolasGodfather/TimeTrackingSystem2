package com.asinovich.dto;

/**
 *
 * @author Nicolas Asinovich.
 */
public class EmployeeDTO {

    private String id;
    private String name;
    private String surname;
    private String position;

    public EmployeeDTO () {
    }

    public EmployeeDTO (String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

}
