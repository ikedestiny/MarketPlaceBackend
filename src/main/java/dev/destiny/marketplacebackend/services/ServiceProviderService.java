package dev.destiny.marketplacebackend.services;

import dev.destiny.marketplacebackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderService {
    @Autowired
    private ServiceRepository service_repo;
}
