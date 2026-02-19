package com.example.serviceBook.controller;


import com.example.serviceBook.entity.CustomerBooking;
//import com.example.serviceBook.entity.ProviderResponse;
import com.example.serviceBook.entity.ProviderResponse;
import com.example.serviceBook.entity.ProviderResponseId;
import com.example.serviceBook.entity.User;
import com.example.serviceBook.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/providers")
public class ProviderController {
    @Autowired
    private ProviderService providerService;


    @PostMapping("/respond")
    public Mono<CustomerBooking> respond(@RequestBody ProviderResponseId response) {
        return providerService.respondToBooking(response);
    }

    @GetMapping("/allBookings")
    public Flux<CustomerBooking> getBookings() {
        return providerService.findBooking();

    }

    @DeleteMapping("/Delete")
    public ResponseEntity<Boolean> deleteAll() {
        providerService.delete();
        return  new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/findcustomers")
    public Flux<User> bookService() {
        return  providerService.findAllCustomers();
//        return customerService.createBooking(booking);
//                .map(savedBooking -> ResponseEntity.ok(savedBooking));
    }
}

