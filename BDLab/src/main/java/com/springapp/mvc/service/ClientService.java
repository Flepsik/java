package com.springapp.mvc.service;

import com.springapp.mvc.entity.Client;

import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface ClientService {

    Client add(Client client);
    void delete(Long id);
    void delete(Client client);
    Client edit(Client client);
    List<Client> getAll();
    Client getById(Long id);
}
