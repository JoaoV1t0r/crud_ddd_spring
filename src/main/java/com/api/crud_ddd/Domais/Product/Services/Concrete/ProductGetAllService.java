package com.api.crud_ddd.Domais.Product.Services.Concrete;

import com.api.crud_ddd.Domais.Product.Services.Abstract.IProductGetAllService;
import com.api.crud_ddd.Infra.Models.Product;
import com.api.crud_ddd.Infra.Repositories.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductGetAllService implements IProductGetAllService {
    private final IProductRepository productRepository;

    public ProductGetAllService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }
}
