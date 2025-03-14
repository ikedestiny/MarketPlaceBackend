package dev.destiny.marketplacebackend.model;

import jakarta.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private ServiceType type;
    @OneToOne
    @JoinColumn(name = "provider_id",nullable = false)
    private MPUser provider;


    public Service() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public MPUser getProvider() {
        return provider;
    }

    public void setProvider(MPUser provider) {
        this.provider = provider;
    }
}
