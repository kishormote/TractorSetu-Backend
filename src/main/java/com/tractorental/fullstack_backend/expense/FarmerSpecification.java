package com.tractorental.fullstack_backend.expense;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FarmerSpecification
{
    public static Specification<Farmers> searchByName(String name)
    {
        return (root, query, criteriaBuilder) ->
        {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty())
            {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
