-- Users table
CREATE TABLE IF NOT EXISTS users (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(255)
);

-- User Roles table
CREATE TABLE IF NOT EXISTS user_roles (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Customer Booking table
CREATE TABLE IF NOT EXISTS customer_booking (
    booking_id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    provider_id BIGINT NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDING'
);

-- Provider Response table
CREATE TABLE IF NOT EXISTS provider_response (
    booking_id BIGINT NOT NULL,
    provider_id BIGINT NOT NULL,
    PRIMARY KEY (booking_id, provider_id),
    CONSTRAINT fk_booking FOREIGN KEY (booking_id) REFERENCES customer_booking(booking_id) ON DELETE CASCADE,
    CONSTRAINT fk_provider FOREIGN KEY (provider_id) REFERENCES users(user_id) ON DELETE CASCADE
);
