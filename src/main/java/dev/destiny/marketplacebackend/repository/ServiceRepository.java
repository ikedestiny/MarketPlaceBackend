package dev.destiny.marketplacebackend.repository;

import dev.destiny.marketplacebackend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Integer> {
}
