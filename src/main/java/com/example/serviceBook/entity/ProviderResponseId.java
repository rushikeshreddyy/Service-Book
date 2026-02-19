package com.example.serviceBook.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProviderResponseId implements Serializable {
    private Long bookingId;

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    private Long providerId;

    public ProviderResponseId() {
    }

    // Getters, Setters, equals, and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderResponseId that = (ProviderResponseId) o;
        return Objects.equals(bookingId, that.bookingId) &&
                Objects.equals(providerId, that.providerId);
    }

    // Override hashCode to ensure consistency with equals
    @Override
    public int hashCode() {
        return Objects.hash(bookingId, providerId);
    }

    // Override toString for debugging purposes
    @Override
    public String toString() {
        return "ProviderResponseId{" +
                "bookingId=" + bookingId +
                ", providerId=" + providerId +
                '}';
    }
}

