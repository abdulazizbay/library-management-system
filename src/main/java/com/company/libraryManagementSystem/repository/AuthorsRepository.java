package com.company.libraryManagementSystem.repository;

import com.company.libraryManagementSystem.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Optional<Authors> findAuthorsByName(String name);

}
