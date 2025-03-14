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
    @OneToOne
    @JoinColumn(name = "business_owner",nullable = false)
    private MPUser owner;

    public Business() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    public MPUser getOwner() {
        return owner;
    }

    public void setOwner(MPUser owner) {
        this.owner = owner;
    }
}
