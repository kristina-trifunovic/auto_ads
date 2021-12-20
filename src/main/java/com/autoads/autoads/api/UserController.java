package com.autoads.autoads.api;

import com.autoads.autoads.service.UserService;
import com.autoads.autoads.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("v1/api/user")
@RestController
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public void addUser(@NonNull @RequestBody User user) {
        userService.addUser(user);
    }
    
    @GetMapping(path = "{id}")
    public Object getUserById(@PathVariable("id")UUID id) {
        return userService.getUserById(id)
                .orElse(null);
    }

    @GetMapping(path = "{id}")
    public int selectAdsFromOneUser(@PathVariable("id") UUID id) {
        return userService.selectAdsFromOneUser(id);
    }
    
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@NonNull @RequestBody User userToUpdate, @PathVariable("id") UUID id) {
        userService.updateUser(id, userToUpdate);
    }
        
    
}
