package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Order;
import com.springapp.mvc.repository.OrderRepository;
import com.springapp.mvc.service.OrderService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderRepository orderRepository;


    @Override
    @Transactional
    public Order add(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    @Transactional
    public Order edit(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    @Transactional
    public List<Order> getAll() {
        return orderRepository.findAll(sortByIdDesc());
    }

    private Sort sortByIdDesc() {
        return new Sort(Sort.Direction.DESC, "id");
    }

    @Override
    @Transactional
    public Order getById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public void changeStatus(Order order) {
        orderRepository.saveAndFlush(order);
    }
}
