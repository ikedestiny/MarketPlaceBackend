package dev.destiny.marketplacebackend.services;

import dev.destiny.marketplacebackend.model.MPUser;
import dev.destiny.marketplacebackend.model.UserRole;
import dev.destiny.marketplacebackend.repository.MPUserRepository;
import org.jboss.logging.BasicLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPUserService implements UserDetailsService {
    @Autowired
    MPUserRepository user_repo;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static final Logger logger = LoggerFactory.getLogger(MPUserService.class);

    public List<MPUser> get_all_users(){
        return user_repo.findAll();
    }
    public List<MPUser> get_all_service_men(){
        return user_repo.findByRole(UserRole.SERVICE_PROVIDER);
    }
    public List<MPUser> get_admins(){
        return user_repo.findByRole(UserRole.ADMIN);
    }
    public List<MPUser> get_clients(){
        return user_repo.findByRole(UserRole.CLIENT);
    }
    public List<MPUser> get_business_owners(){
        return user_repo.findByRole(UserRole.BUSINESS_OWNER);
    }
    public MPUser register_user(MPUser user) {
        logger.info("Attempting to register user: {}", user.getUsername());
        if (user_repo.findByUsername(user.getUsername()).isPresent()) {
            logger.warn("Username already exists: {}", user.getUsername());
            throw new RuntimeException("Username already exists");
        }
        if (user_repo.findByEmail(user.getEmail()).isPresent()) {
            logger.warn("Email already exists: {}", user.getEmail());
            throw new RuntimeException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        MPUser registeredUser = user_repo.save(user);
        logger.info("User registered successfully: {}", user.getUsername());
        return registeredUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MPUser user = user_repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole().name())
                .build();
    }
}
