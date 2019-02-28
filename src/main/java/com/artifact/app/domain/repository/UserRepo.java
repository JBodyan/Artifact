package com.artifact.app.domain.repository;

import com.artifact.app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
