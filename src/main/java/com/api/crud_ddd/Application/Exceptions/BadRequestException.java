package com.api.crud_ddd.Application.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Name already exits")
public class BadRequestException extends RuntimeException {
}
