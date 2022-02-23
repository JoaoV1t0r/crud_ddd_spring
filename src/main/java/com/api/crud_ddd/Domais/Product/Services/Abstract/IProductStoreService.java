package com.api.crud_ddd.Domais.Product.Services.Abstract;

import com.api.crud_ddd.Application.DTOs.Product.ProductRequest;

public interface IProductStoreService {
    Boolean saveProduct(ProductRequest productRequest);
}
