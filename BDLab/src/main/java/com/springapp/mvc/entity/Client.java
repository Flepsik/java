package com.springapp.mvc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id_client", length = 6, nullable = false)
    private long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<Order> orders;

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Client() {
    }

    public Client(String name, String surname, String phone) {

        this.name = name;
        this.surname = surname;
        this.phone = phone;
        orders = new HashSet<Order>();
    }

    public Client(String name, String surname, String phone, Set<Order> orders) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.orders = orders;
    }
}