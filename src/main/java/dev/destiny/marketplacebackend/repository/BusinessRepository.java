package dev.destiny.marketplacebackend.repository;

import dev.destiny.marketplacebackend.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {

}
