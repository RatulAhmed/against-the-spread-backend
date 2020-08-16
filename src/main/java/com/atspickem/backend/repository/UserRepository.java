package com.atspickem.backend.repository;

import com.atspickem.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Override
    <S extends User> S save(S s);
}
