package com.springapp.mvc.repository;

import com.springapp.mvc.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Fleps_000 on 16.04.2015.
 */
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
