package com.company.libraryManagementSystem.service;
import com.company.libraryManagementSystem.model.Users;
import com.company.libraryManagementSystem.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Users saveUsers(@Valid Users users) {
        Optional<Users> existingUser = usersRepository.findByEmail(users.getEmail());
        if (existingUser.isPresent() && existingUser.get().getId() != users.getId()) {
            throw new IllegalArgumentException("User already exists");
        }
        if (users.getPassword() != null) {
            users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        }
        return usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(user -> {
                    user.setPassword("***");
                    return user;
                })
                .collect(Collectors.toList());
    }



}
