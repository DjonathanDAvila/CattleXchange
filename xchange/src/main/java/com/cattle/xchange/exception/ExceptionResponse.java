package com.cattle.xchange.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse{
    private Date timestamp;
    private String message;
    private String details;
}