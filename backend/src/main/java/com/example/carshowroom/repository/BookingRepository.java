package com.example.carshowroom.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.carshowroom.model.Booking;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByUserId(String userId);

    List<Booking> findByStatus(String status);
}
