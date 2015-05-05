package com.springapp.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id_worker", length = 6, nullable = false)
    private long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patromymic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_position", nullable = false)
    private Position position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "status")
    private boolean status;

    public Worker() {
        status = true;
    }

    public Worker(String name, String surname, String patromymic, Position position, double salary, boolean status) {
        this.name = name;
        this.surname = surname;
        this.patromymic = patromymic;
        this.position = position;
        this.salary = salary;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatromymic() {
        return patromymic;
    }

    public void setPatromymic(String patromymic) {
        this.patromymic = patromymic;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
