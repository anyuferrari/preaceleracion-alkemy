package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IconsRepository extends JpaRepository<Icon, Long> {
    
}
