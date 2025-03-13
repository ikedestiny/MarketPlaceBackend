package dev.destiny.marketplacebackend.model;

import jakarta.persistence.*;

@Entity
public class MPUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;
    String username;
    String email;
    String password;
    UserRole role;

    public MPUser() {
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
