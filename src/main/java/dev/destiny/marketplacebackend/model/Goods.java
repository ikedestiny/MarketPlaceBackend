package dev.destiny.marketplacebackend.model;

import jakarta.persistence.*;

@Entity
public class Goods {
    @Id
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id",nullable = false)
    private Business business;
    private Integer quantity;


}
