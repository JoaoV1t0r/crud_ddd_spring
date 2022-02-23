package com.api.crud_ddd.Application.DTOs.Product;

import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotEmpty;

public class ProductRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotFound
    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
