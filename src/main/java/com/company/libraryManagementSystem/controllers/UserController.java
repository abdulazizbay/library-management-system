package com.company.libraryManagementSystem.controllers;

import com.company.libraryManagementSystem.model.Users;
import com.company.libraryManagementSystem.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/getUsers")
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Users user) {
        try{
            Users createdUser = usersService.saveUsers(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
