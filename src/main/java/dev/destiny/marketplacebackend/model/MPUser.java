package dev.destiny.marketplacebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class MPUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Username is required")
    private String username;

    @Column(unique = true)
    @Email(message = "Email should be valid")
    private String email;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Role is required")
    private UserRole role;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
