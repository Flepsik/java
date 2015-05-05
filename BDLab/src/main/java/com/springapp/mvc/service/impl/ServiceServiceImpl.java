package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Service;
import com.springapp.mvc.repository.ServiceRepository;
import com.springapp.mvc.service.ServiceService;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Resource
    private ServiceRepository serviceRepository;


    @Override
    @Transactional
    public Service add(Service service) {
        return serviceRepository.saveAndFlush(service);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        serviceRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Service service) {
        serviceRepository.delete(service);
    }

    @Override
    @Transactional
    public Service edit(Service service) {
        return serviceRepository.saveAndFlush(service);
    }

    @Override
    @Transactional
    public List<Service> getAll() {
        return serviceRepository.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }

    @Override
    @Transactional
    public Service getById(Long id) {
        return serviceRepository.findOne(id);
    }

    @Override
    @Transactional
    public void changeStatus(Service service) {
        serviceRepository.saveAndFlush(service);
    }
}
