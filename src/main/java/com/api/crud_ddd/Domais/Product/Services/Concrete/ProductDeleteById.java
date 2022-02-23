package com.api.crud_ddd.Domais.Product.Services.Concrete;

import com.api.crud_ddd.Application.Exceptions.BadRequestException;
import com.api.crud_ddd.Domais.Product.Services.Abstract.IProductDeleteById;
import com.api.crud_ddd.Infra.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteById implements IProductDeleteById {
    private final IProductRepository productRepository;

    public ProductDeleteById(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean deleteProductById(Long id) {
        var product = this.productRepository.findById(id);
        if (product.isEmpty()) {
            throw new BadRequestException();
        }
        this.productRepository.deleteById(product.get().getId());
        return true;
    }
}
