package com.api.crud_ddd.Infra.Repositories;

import com.api.crud_ddd.Infra.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    Optional<Product> findById(Long id);
}
