package dev.destiny.marketplacebackend.controllers;

import dev.destiny.marketplacebackend.model.MPUser;
import dev.destiny.marketplacebackend.services.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MPUserService userService;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard";
    }


    @GetMapping("/all_users")
    public ResponseEntity<List<MPUser>> getAllUsers(){
        return ResponseEntity.ok(userService.get_all_users());
    }

    @DeleteMapping("/delete_user")
    public ResponseEntity<String> deleteUserById(@RequestParam("user_id") Integer id){
    String res = userService.deleteById(id);
    if(res == null){
        return ResponseEntity.status(404).body("no user with such id");
    }
    return ResponseEntity.ok(res);
    }


}
