package com.api.crud_ddd.Domais.Product.Services.Abstract;

import com.api.crud_ddd.Infra.Models.Product;

import java.util.Optional;

public interface IProductGetById {
    Optional<Product> getProductById(Long id);
}
