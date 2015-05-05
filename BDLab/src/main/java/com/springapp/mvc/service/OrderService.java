package com.springapp.mvc.service;

import com.springapp.mvc.entity.Order;

import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface OrderService {
    Order add(Order order);
    void delete(Long id);
    void delete(Order order);
    Order edit(Order order);
    List<Order> getAll();
    Order getById(Long id);
    void changeStatus(Order order);
}
