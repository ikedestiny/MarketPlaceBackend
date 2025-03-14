package dev.destiny.marketplacebackend.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('CLIENT','ADMIN','BUSINESS_OWNER','SERVICE_PROVIDER')")
    public String clientProfile() {
        return "Welcome to the Client Profile";
    }
}
