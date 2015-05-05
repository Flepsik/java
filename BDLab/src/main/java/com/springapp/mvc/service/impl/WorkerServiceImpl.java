package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Worker;
import com.springapp.mvc.repository.WorkerRepository;
import com.springapp.mvc.service.WorkerService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Resource
    WorkerRepository workerRepository;

    @Override
    @Transactional
    public Worker add(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        workerRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }

    @Override
    @Transactional
    public Worker edit(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    @Transactional
    public List<Worker> getAll() {
        return workerRepository.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    @Override
    @Transactional
    public Worker getById(Long id) {
        return workerRepository.findOne(id);
    }

    @Override
    public void changeStatus(Worker worker) {
        workerRepository.saveAndFlush(worker);
    }
}
