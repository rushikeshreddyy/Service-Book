package com.example.serviceBook.repository;


import com.example.serviceBook.entity.UserRole;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRoleRepository extends ReactiveCrudRepository<UserRole, Long> {

    Flux<UserRole> findByUserId(Long userId);  // Get roles by userId
}

