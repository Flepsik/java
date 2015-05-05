package com.springapp.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id_position", length = 6, nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Position(String name) {
        this.name = name;
    }

    public Position() {
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


}
