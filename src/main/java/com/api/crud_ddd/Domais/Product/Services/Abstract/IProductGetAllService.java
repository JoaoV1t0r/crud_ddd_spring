package com.api.crud_ddd.Domais.Product.Services.Abstract;

import com.api.crud_ddd.Infra.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductGetAllService {
    Page<Product> getAllProducts(Pageable pageable);
}
