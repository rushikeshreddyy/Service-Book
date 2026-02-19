package com.example.serviceBook.service;


import com.example.serviceBook.entity.User;
import com.example.serviceBook.entity.UserRole;
import com.example.serviceBook.repository.UserRepository;
import com.example.serviceBook.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    private static final Set<String> VALID_ROLES = Set.of("CUSTOMER", "PROVIDER");

    public Mono<User> registerUser(User user) {
        User user1 = new User();

        user1.setName(user.getName());
        user1.setUsername(generateUniqueUsername(user.getName()));
//        user1.setPassword(encoder.encode(user.getPassword()));
        user1.setPassword(user.getPassword());
        user1.setAddress(user.getAddress());
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());

        // Save user to the database first
//        return userRepository.save(user1);
//                .flatMap(savedUser -> {
//                    // Add roles to the user after saving
//                    if (user.getRoles() != null && !user.getRoles().isEmpty()) {
//                        if (!VALID_ROLES.containsAll(user.getRoles())) {
//                            return Mono.error(new IllegalArgumentException("Invalid role provided!"));
//                        }
//                        // Create UserRole entities and save them in user_roles table
//                        return Flux.fromIterable(user.getRoles())
//                                .map(role -> {
//                                    UserRole userRole = new UserRole();
//                                    userRole.setUserId(savedUser.getId());
//                                    userRole.setRole(role);
//                                    return userRole;
//                                })
//                                .flatMap(userRoleRepository::save)
//                                .then(Mono.just(savedUser));   // Return the saved user
//                    }
//                    return Mono.just(savedUser);
//                });
         return userRepository.save(user1);
//            return    u.flatMap(savedUser -> {
//                    // Add roles to the user after saving
//                    if (user.getRoles() != null && !user.getRoles().isEmpty()) {
//                        if (!VALID_ROLES.containsAll(user.getRoles())) {
//                            return Mono.error(new IllegalArgumentException("Invalid role provided!"));
//                        }
//                        // Create UserRole entities and save them in user_roles table
//                        return Flux.fromIterable(user.getRoles())
//                                .map(role -> {
//                                    UserRole userRole = new UserRole();
//                                    userRole.setUserId(savedUser.getId());
//                                    userRole.setRole(role);
//                                    return userRole;
//                                })
//                                .flatMap(userRoleRepository::save)
//                                .then(Mono.just(savedUser));   // Return the saved user
//                    }
//                    return Mono.just(savedUser);
//                });
    }

    public Mono<User> addRole(String username, String role) {
        return userRepository.findByUsername(username)
                .flatMap(user -> {
                    if (!VALID_ROLES.contains(role)) {
                        return Mono.error(new IllegalArgumentException("Invalid role provided!"));
                    }
                    // Create a new UserRole and save it in user_roles table
                    UserRole userRole = new UserRole();
                    userRole.setUserId(user.getId());
                    userRole.setRole(role);
                    return userRoleRepository.save(userRole)
                            .thenReturn(user);  // Return the user after role has been added
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException("User not found")));
    }

    public String generateUniqueUsername(String baseName) {
        String username = baseName.replaceAll("\\s+", "").toLowerCase();
        return username + "_" + Instant.now().getEpochSecond();
    }

    public Flux<User> findAllCustomers() {
        return userRepository.findAll();
    }
}

