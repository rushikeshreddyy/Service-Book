package com.example.serviceBook.entity;

import com.example.serviceBook.entity.ProviderResponseId;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("provider_response")
public class ProviderResponse {

    @Id
    private ProviderResponseId id; // Composite key

    @Column("booking_id")
    private Long bookingId;

    @Column("provider_id")
    private Long providerId;

    // Getters and Setters
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
}

