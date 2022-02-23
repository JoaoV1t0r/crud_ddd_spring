package com.api.crud_ddd.Application.Models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseResponse<T>  {
    protected String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    protected Integer statusCode;
    protected T data;

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public BaseResponse<T> setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public ResponseEntity<Object> response(){
        return ResponseEntity.status(this.statusCode).body(this);
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
