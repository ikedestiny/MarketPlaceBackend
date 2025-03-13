package dev.destiny.marketplacebackend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true, nullable = false)
    private String name;
    private String address;
    @Column(unique = true, nullable = false)
    private String email;
    private String description;
    @OneToMany(mappedBy = "business",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Goods> goods;
}
