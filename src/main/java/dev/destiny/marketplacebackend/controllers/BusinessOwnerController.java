package dev.destiny.marketplacebackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessOwnerController {
    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('BUSINESS_OWNER','ADMIN')")
    public String businessProfile() {
        return "Welcome to the Admin Dashboard";
    }
}
