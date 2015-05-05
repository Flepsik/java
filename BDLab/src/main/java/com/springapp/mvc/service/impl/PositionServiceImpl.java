package com.springapp.mvc.service.impl;

import com.springapp.mvc.entity.Position;
import com.springapp.mvc.repository.PositionRepository;
import com.springapp.mvc.service.PositionService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionRepository positionRepository;

    @Override
    @Transactional
    public Position add(Position position) {
        return positionRepository.saveAndFlush(position);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        positionRepository.delete(id);
    }

    @Override
    @Transactional
    public void delete(Position position) {
        positionRepository.delete(position);
    }

    @Override
    @Transactional
    public Position edit(Position position) {
        return positionRepository.saveAndFlush(position);
    }

    @Override
    @Transactional
    public List<Position> getAll() {
        return  positionRepository.findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    @Override
    @Transactional
    public Position getById(Long id) {
        return positionRepository.findOne(id);
    }
}
