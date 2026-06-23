package com.example.carshowroom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carshowroom.model.Car;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findByCategory(String category);

    List<Car> findByNameContainingIgnoreCase(String name);
}
