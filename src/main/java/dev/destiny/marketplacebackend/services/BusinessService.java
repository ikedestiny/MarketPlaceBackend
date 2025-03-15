package dev.destiny.marketplacebackend.services;

import dev.destiny.marketplacebackend.model.Business;
import dev.destiny.marketplacebackend.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository biz_repo;

    public List<Business> get_all_businesses(){
        return biz_repo.findAll();
    }
    public Business create_new_business(Business business){
        return biz_repo.save(business);
    }
    public void close_business(Integer id){
         biz_repo.deleteById(id);
    }

    public Optional<Business> findBusinessById(Integer businessId) {
        return biz_repo.findById(businessId);
    }
}
