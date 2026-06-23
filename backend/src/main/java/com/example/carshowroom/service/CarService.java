package com.example.carshowroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carshowroom.model.Car;
import com.example.carshowroom.repository.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(String id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);   // fixed: was CarRepository.save(car) - static call on interface
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }
}
