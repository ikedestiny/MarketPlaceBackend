package dev.destiny.marketplacebackend.repository;

import dev.destiny.marketplacebackend.model.MPUser;
import dev.destiny.marketplacebackend.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MPUserRepository extends JpaRepository<MPUser,Integer> {
    @Query("SELECT u FROM MPUser u WHERE u.role = :role")
    List<MPUser> findByRole(@Param("role") UserRole role);

    Optional<MPUser> findByUsername(String username);

    Optional<MPUser> findByEmail(String email);
}
