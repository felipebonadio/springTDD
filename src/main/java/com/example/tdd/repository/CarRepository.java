package com.example.tdd.repository;

import com.example.tdd.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Car findByName(String name);
}
