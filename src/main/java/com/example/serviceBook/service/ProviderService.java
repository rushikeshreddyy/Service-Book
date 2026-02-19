package com.example.serviceBook.service;

import com.example.serviceBook.entity.CustomerBooking;
//import com.example.serviceBook.entity.ProviderResponse;
import com.example.serviceBook.entity.ProviderResponseId;
import com.example.serviceBook.entity.User;
import com.example.serviceBook.repository.CustomerBookingRepository;
import com.example.serviceBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProviderService {
//    @Autowired
//    private ReactiveKafkaProducerTemplate<String, ProviderResponse> providerProducerTemplate;



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerBookingRepository customerBookingRepository;

    public Mono<CustomerBooking> respondToBooking(ProviderResponseId response) {
        Mono<CustomerBooking> cus=customerBookingRepository.findById(response.getBookingId());
//        assignmentRepository.save(response);
        return cus.flatMap(u-> {
            CustomerBooking c=new CustomerBooking();
            c.setCustomerId(u.getCustomerId());
            c.setId(u.getId());
            c.setProviderId(response.getProviderId());
            c.setStatus("ASSIGNED");
            return customerBookingRepository.save(c);
        });

//        return providerProducerTemplate.send(providerResponseTopic, response.getBookingId().toString(), response).then();
    }

    public Flux<CustomerBooking> findBooking() {
        return customerBookingRepository.findByStatus("PENDING");
//        return providerProducerTemplate.send(providerResponseTopic, response.getBookingId().toString(), response).then();
    }

    public void delete() {
         userRepository.deleteAll();
    }

    public Flux<User> findAllCustomers(){
        return userRepository.findAll();
    }
}

