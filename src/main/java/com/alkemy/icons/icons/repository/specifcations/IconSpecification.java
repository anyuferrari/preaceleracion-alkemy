package com.alkemy.icons.icons.repository.specifcations;

import com.alkemy.icons.icons.dto.IconsFiltersDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class IconSpecification {
    public Specification<Icon> getByFilters(IconsFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            
            List<Predicate> predicates = new ArrayList<>();
            
            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("denominacion")),
                            "%"+ filtersDTO.getName().toLowerCase() + "%"
                    )
                );
            }
            if (StringUtils.hasLength(filtersDTO.getDate())){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getDate(), formatter);
                
                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("fecha_creacion"),date)
                );
            }
            if(!CollectionUtils.isEmpty(filtersDTO.getCities())){
                Join<Pais,Icon> join = root.join("paises", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(citiesId.in(filtersDTO.getCities()));                
            }
            
            //Eliminar duplicados
            query.distinct(true);
            
            //Ordenador
            String  orderByField = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
