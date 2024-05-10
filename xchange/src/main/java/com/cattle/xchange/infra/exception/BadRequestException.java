package com.cattle.xchange.infra.exception;

import org.springframework.lang.Nullable;

public class BadRequestException extends RuntimeException{
    public BadRequestException(@Nullable String message) {
        super(message);
    }
}
