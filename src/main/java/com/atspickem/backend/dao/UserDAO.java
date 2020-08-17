package com.atspickem.backend.dao;

import com.atspickem.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);


}
