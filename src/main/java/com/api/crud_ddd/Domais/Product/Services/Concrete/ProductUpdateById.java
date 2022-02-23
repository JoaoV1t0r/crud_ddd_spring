package com.api.crud_ddd.Domais.Product.Services.Concrete;

import com.api.crud_ddd.Application.DTOs.Product.ProductRequest;
import com.api.crud_ddd.Application.Exceptions.BadRequestException;
import com.api.crud_ddd.Domais.Product.Services.Abstract.IProductUpdateById;
import com.api.crud_ddd.Infra.Models.Product;
import com.api.crud_ddd.Infra.Repositories.IProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ProductUpdateById implements IProductUpdateById {
    private final IProductRepository productRepository;
    private ProductRequest productRequest;
    private Product product;

    public ProductUpdateById(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product updateProductById(Long id, ProductRequest productRequest) {
        this.productRequest = productRequest;
        this.setProduct(id);
        this.run();
        return this.product;
    }

    private void run() {
        this.validateNameProductUnique();
        this.updateProduct();
    }

    private void setProduct(Long id) {
        var _product = this.productRepository.findById(id);
        if (_product.isEmpty()) {
            throw new BadRequestException();
        }
        this.product = _product.get();
    }

    private void validateNameProductUnique() {
        if (!this.product.getName().equals(this.productRequest.getName())) {
            var validation = this.productRepository.existsByName(this.productRequest.getName());
            if (validation) throw new BadRequestException();
        }
    }

    private void updateProduct() {
        BeanUtils.copyProperties(this.productRequest, this.product);
        this.product.setUpdated_at(LocalDateTime.now(ZoneId.of("UTC")));
        this.productRepository.save(product);
    }
}
