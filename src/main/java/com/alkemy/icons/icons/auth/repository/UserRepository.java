package com.alkemy.icons.icons.auth.repository;

import com.alkemy.icons.icons.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
