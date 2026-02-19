package com.example.serviceBook.controller;


import com.example.serviceBook.entity.CustomerBooking;
import com.example.serviceBook.entity.User;
import com.example.serviceBook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @PostMapping("/book")
    public Mono<CustomerBooking> bookService(@RequestBody CustomerBooking booking) {
       return customerService.createBooking(booking);
    }

    @GetMapping("/findcustomers")
    public ResponseEntity<Flux<User>> findService() {
        return  new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }
}

