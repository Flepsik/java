package com.springapp.mvc.service;


import com.springapp.mvc.entity.Service;

import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface ServiceService {
    Service add(Service service);
    void delete(Long id);
    void delete(Service service);
    Service edit(Service service);
    List<Service> getAll();
    Service getById(Long id);
    void changeStatus(Service status);
}
