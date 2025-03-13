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
    @OneToOne(mappedBy = "provider",cascade = CascadeType.ALL)
    private Service service;
    @OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
    private Business business;


    public MPUser() {
    }

    public UserRole getRole() {
        return role;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
