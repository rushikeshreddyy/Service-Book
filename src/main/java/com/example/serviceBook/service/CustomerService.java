package com.example.serviceBook.service;


import com.example.serviceBook.entity.CustomerBooking;
import com.example.serviceBook.entity.User;
import com.example.serviceBook.repository.CustomerBookingRepository;
import com.example.serviceBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
//    @Autowired
//    private  ReactiveKafkaProducerTemplate<String, CustomerBooking> kafkaTemplate;
    @Autowired
    private CustomerBookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;
//    @Value("${kafka.topic.booking}")
//    private String bookingTopic;


    public Mono<CustomerBooking> createBooking(CustomerBooking booking) {
        booking.setStatus("PENDING");

        return bookingRepository.save(booking);
//                .flatMap(savedBooking -> kafkaTemplate.send(bookingTopic, savedBooking.getId().toString(), savedBooking)
//                        .thenReturn(savedBooking));
    }
    public Flux<User> findAllCustomers(){
        return userRepository.findAll();
    }

}

