package com.api.crud_ddd.Application.Controllers;

import com.api.crud_ddd.Application.DTOs.Product.ProductRequest;
import com.api.crud_ddd.Application.Models.BaseResponse;
import com.api.crud_ddd.Domais.Product.Services.Abstract.*;
import com.api.crud_ddd.Infra.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductsController {
    private final IProductStoreService productStoreService;
    private final IProductGetAllService productGetAllService;
    private final IProductGetById productGetById;
    private final IProductDeleteById productDeleteById;
    private final IProductUpdateById productUpdateById;

    public ProductsController(
            IProductStoreService productStoreService,
            IProductGetAllService productGetAllService,
            IProductGetById productGetById,
            IProductDeleteById productDeleteById,
            IProductUpdateById productUpdateById
    ) {
        this.productStoreService = productStoreService;
        this.productGetAllService = productGetAllService;
        this.productGetById = productGetById;
        this.productDeleteById = productDeleteById;
        this.productUpdateById= productUpdateById;
    }

    @PostMapping
    public ResponseEntity<Object> storeProduct(@Valid @RequestBody ProductRequest productRequest) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        return response.setMessage("Product created successfully!")
                .setStatusCode(HttpStatus.CREATED.value())
                .setData(this.productStoreService.saveProduct(productRequest))
                .response();

    }

    @GetMapping
    public ResponseEntity<Object> getAllProducts(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.ASC
            ) Pageable pageable
    ) {
        BaseResponse<Page<Product>> response = new BaseResponse<>();
        return response.setStatusCode(HttpStatus.OK.value())
                .setMessage("List products!").
                setData(this.productGetAllService.getAllProducts(pageable))
                .response();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductsById(@PathVariable(value = "id") Long id) {
        BaseResponse<Optional<Product>> response = new BaseResponse<>();
        return response.setStatusCode(HttpStatus.OK.value())
                .setMessage("Product found successfully!")
                .setData(this.productGetById.getProductById(id))
                .response();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable(value = "id") Long id) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        return response.setMessage("Product deleted successfully!")
                .setStatusCode(HttpStatus.OK.value())
                .setData(this.productDeleteById.deleteProductById(id))
                .response();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProductById(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody ProductRequest productRequest
    ) {
        BaseResponse<Product> response = new BaseResponse<>();
        return response.setMessage("Product deleted successfully!")
                .setStatusCode(HttpStatus.OK.value())
                .setData(this.productUpdateById.updateProductById(id, productRequest))
                .response();
    }
}
