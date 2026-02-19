package com.example.serviceBook.entity;

//import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//@Entity
@Table(name="cutomer_booking")
public class CustomerBooking {


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column("booking_id ")
    private Long id;
    @Column("customer_id ")
    private Long customerId;
    @Column("provider_id ")
    private Long providerId;
    private String status; // "PENDING", "ASSIGNED"

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
}
