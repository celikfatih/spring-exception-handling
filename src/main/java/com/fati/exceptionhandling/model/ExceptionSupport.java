package com.fati.exceptionhandling.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionSupport implements Serializable {

    private static final long serialVersionUID = 2862159074061276163L;

    HttpStatus status;
    String code;
    String message;
    String developerMessage;
}
