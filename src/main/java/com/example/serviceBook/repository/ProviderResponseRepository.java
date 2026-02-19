package com.example.serviceBook.repository;



import com.example.serviceBook.entity.ProviderResponse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface ProviderResponseRepository extends ReactiveCrudRepository<ProviderResponse, Long> {

    // Custom query method to find responses by booking ID
   Flux< List<ProviderResponse>> findByBookingId(Long bookingId);

    // Custom query method to find responses by service provider ID
    Flux<List<ProviderResponse>> findByProviderId(Long providerId);

}
//
