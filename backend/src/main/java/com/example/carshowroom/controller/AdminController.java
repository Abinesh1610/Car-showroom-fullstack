package com.example.carshowroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.carshowroom.model.Booking;
import com.example.carshowroom.model.Car;
import com.example.carshowroom.model.User;
import com.example.carshowroom.repository.BookingRepository;
import com.example.carshowroom.repository.CarRepository;
import com.example.carshowroom.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // ── Dashboard Stats ──────────────────────────────────────────────────────

    @GetMapping("/stats")
    public DashboardStats getStats() {
        DashboardStats stats = new DashboardStats();
        stats.setTotalCars(carRepository.count());
        stats.setTotalUsers(userRepository.count());
        stats.setTotalBookings(bookingRepository.count());
        return stats;
    }

    // ── Users ─────────────────────────────────────────────────────────────────

    @GetMapping("/users")
    public List<User> getUsers() {           // fixed: was List<Use> (wrong WebMvc internal type)
        return userRepository.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }

    // ── Cars ──────────────────────────────────────────────────────────────────

    @GetMapping("/cars")
    public List<Car> getCars() {             // fixed: was List<User> — wrong com.example.demo.model type
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable String id) {
        carRepository.deleteById(id);
    }

    // ── Bookings ──────────────────────────────────────────────────────────────

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @PutMapping("/bookings/{id}/approve")
    public Booking approveBooking(@PathVariable String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
        booking.setStatus("Approved");
        return bookingRepository.save(booking);
    }

    @PutMapping("/bookings/{id}/reject")
    public Booking rejectBooking(@PathVariable String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + id));
        booking.setStatus("Rejected");
        return bookingRepository.save(booking);
    }

    // ── Inner DTO ─────────────────────────────────────────────────────────────

    public static class DashboardStats {

        private long totalCars;
        private long totalUsers;
        private long totalBookings;

        public long getTotalCars() { return totalCars; }
        public void setTotalCars(long totalCars) { this.totalCars = totalCars; }

        public long getTotalUsers() { return totalUsers; }
        public void setTotalUsers(long totalUsers) { this.totalUsers = totalUsers; }

        public long getTotalBookings() { return totalBookings; }
        public void setTotalBookings(long totalBookings) { this.totalBookings = totalBookings; }
    }
}
