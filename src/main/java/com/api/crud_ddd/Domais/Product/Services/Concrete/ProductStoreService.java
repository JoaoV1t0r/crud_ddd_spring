package com.api.crud_ddd.Domais.Product.Services.Concrete;

import com.api.crud_ddd.Application.DTOs.Product.ProductRequest;
import com.api.crud_ddd.Application.Exceptions.BadRequestException;
import com.api.crud_ddd.Domais.Product.Services.Abstract.IProductStoreService;
import com.api.crud_ddd.Infra.Models.Product;
import com.api.crud_ddd.Infra.Repositories.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductStoreService implements IProductStoreService {
    private final IProductRepository productRepository;
    private ProductRequest productRequest;

    public ProductStoreService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Boolean saveProduct(ProductRequest productRequest) {
        this.productRequest = productRequest;
        this.run();
        return true;
    }

    private void run() {
        this.validateNameProductUnique();
        this.createProduct();
    }

    private void validateNameProductUnique() {
        var validation = this.productRepository.existsByName(this.productRequest.getName());
        if (validation) throw new BadRequestException();
    }

    private void createProduct() {
        var product = new Product();
        BeanUtils.copyProperties(this.productRequest, product);
        this.productRepository.save(product);
    }
}
