package com.springapp.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id_service", length = 6, nullable = false)
    private long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "status")
    private boolean status;

    public Service() {
        status = true;
    }

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
        status = true;
    }

    public Service(String name, double price, boolean status) {
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
