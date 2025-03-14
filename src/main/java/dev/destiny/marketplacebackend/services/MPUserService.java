package dev.destiny.marketplacebackend.services;

import dev.destiny.marketplacebackend.model.MPUser;
import dev.destiny.marketplacebackend.model.UserRole;
import dev.destiny.marketplacebackend.repository.MPUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MPUserService implements UserDetailsService {
    @Autowired
    MPUserRepository user_repo;

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
    public MPUser register_user(MPUser user){
        return user_repo.save(user);
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
