package com.example.serviceBook.controller;


import com.example.serviceBook.entity.User;
import com.example.serviceBook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Mono<User>  registerUser(@RequestBody User user) {
        Mono<User> u= authService.registerUser(user);
        System.out.println(u);
        return u;
    }

    @PutMapping("/add-role")
    public Mono<User> addRole(@RequestParam String username, @RequestParam String role) {
        return authService.addRole(username, role);
    }

    @GetMapping("/findcustomers")
    public ResponseEntity<Flux<User>> bookService() {
        Flux<User> r=authService.findAllCustomers();
        r.doOnNext(user -> {
            System.out.println("User details: " + user.getId()+" "+user.getUsername());
        }).subscribe();
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


//    @PutMapping("/update")
//    public ResponseEntity<List<User>> updatePassword() {
//        return  new ResponseEntity<>(authService.updateP(), HttpStatus.OK);
//    }
}


