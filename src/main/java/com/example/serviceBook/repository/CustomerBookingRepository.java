package com.example.serviceBook.repository;



import com.example.serviceBook.entity.CustomerBooking;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface CustomerBookingRepository extends ReactiveCrudRepository<CustomerBooking, Long> {

    // Custom query method to find bookings by customer ID
    Flux<CustomerBooking> findByCustomerId(Long customerId);

//    List<CustomerBooking> findById(Long id);

    // Custom query method to find bookings by status
    Flux<CustomerBooking> findByStatus(String status);
}

