package com.springapp.mvc.service;

import com.springapp.mvc.entity.Worker;

import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface WorkerService {

    Worker add(Worker worker);
    void delete(Long id);
    void delete(Worker worker);
    Worker edit(Worker worker);
    List<Worker> getAll();
    Worker getById(Long id);
    void changeStatus(Worker worker);
}
