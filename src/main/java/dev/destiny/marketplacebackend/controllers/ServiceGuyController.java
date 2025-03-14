package dev.destiny.marketplacebackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceGuyController {
    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('SERVICE_PROVIDER','ADMIN')")
    public String serviceProfile() {
        return "Welcome to the service Profile";
    }
}
