package com.asinovich.domain;

import javax.persistence.*;

/**
 * Реализация Работника как Сущности
 *
 * @author Nicolas Asinovich.
 */

@Entity
@Table (name = "employee")
public class Employee {
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column(name = "position")
    private String position;

    public Employee () {
    }

    public long getId () {
        return id;
    }

    public void setId (long id) {
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
