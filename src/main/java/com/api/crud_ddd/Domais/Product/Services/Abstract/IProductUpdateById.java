package com.api.crud_ddd.Domais.Product.Services.Abstract;

import com.api.crud_ddd.Application.DTOs.Product.ProductRequest;
import com.api.crud_ddd.Infra.Models.Product;

public interface IProductUpdateById {
    Product updateProductById(Long id, ProductRequest productRequest);
}
