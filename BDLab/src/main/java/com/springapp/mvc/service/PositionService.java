package com.springapp.mvc.service;

import com.springapp.mvc.entity.Position;

import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface PositionService {
    Position add(Position position);
    void delete(Long id);
    void delete(Position position);
    Position edit(Position position);
    List<Position> getAll();
    Position getById(Long id);
}
