package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Client;
import com.springapp.mvc.repository.ClientRepository;
import com.springapp.mvc.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    ClientRepository clientRepository;

    @Override
    @Transactional
    public Client add(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    @Transactional
    public Client edit(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    @Transactional
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public Client getById(Long id) {
        return clientRepository.findOne(id);
    }
}
