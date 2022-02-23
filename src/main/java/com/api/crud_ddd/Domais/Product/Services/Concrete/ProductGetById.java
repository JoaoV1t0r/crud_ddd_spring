package com.api.crud_ddd.Domais.Product.Services.Concrete;

import com.api.crud_ddd.Application.Exceptions.BadRequestException;
import com.api.crud_ddd.Domais.Product.Services.Abstract.IProductGetById;
import com.api.crud_ddd.Infra.Models.Product;
import com.api.crud_ddd.Infra.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductGetById implements IProductGetById {
    private final IProductRepository productRepository;

    public ProductGetById(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Long id) {
        var product =  productRepository.findById(id);
        if(product.isEmpty()){
            throw new BadRequestException();
        }
        return product;
    }
}
