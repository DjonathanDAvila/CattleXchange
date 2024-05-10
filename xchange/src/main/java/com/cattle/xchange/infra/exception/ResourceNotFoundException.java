package com.cattle.xchange.infra.exception;

import org.springframework.lang.Nullable;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(@Nullable String message) {
        super(message);
    }
}
