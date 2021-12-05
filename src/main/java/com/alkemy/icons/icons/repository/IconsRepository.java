package com.alkemy.icons.icons.repository;

import com.alkemy.icons.icons.entity.Icon;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface IconsRepository extends JpaRepository<Icon, Long>, JpaSpecificationExecutor<Icon> {
    @Override
    List<Icon> findAll(Specification<Icon> spec);
}
