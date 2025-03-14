package dev.destiny.marketplacebackend.repository;

import dev.destiny.marketplacebackend.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, String> {
}
