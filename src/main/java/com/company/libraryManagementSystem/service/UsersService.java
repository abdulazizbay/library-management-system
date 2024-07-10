package com.company.libraryManagementSystem.service;

import com.company.libraryManagementSystem.model.Users;

import java.util.List;

public interface UsersService {
    public Users saveUsers(Users users);
    public List<Users> getAllUsers();
}
