package com.fati.exceptionhandling.exception;

import com.fati.exceptionhandling.configuration.CustomDBMessageSource;
import com.fati.exceptionhandling.model.ExceptionSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * author @ fati
 * created @ 10.08.2020
 */

@ControllerAdvice
@RequiredArgsConstructor
public class GenericRestExceptionHandler {

    private final CustomDBMessageSource messageSource;

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<ExceptionSupport> handleCarNotFoundException(CarNotFoundException e, Locale locale) {
        return new ResponseEntity<>(createException(e, HttpStatus.NOT_FOUND, locale), HttpStatus.NOT_FOUND);
    }

    public ExceptionSupport createException(Exception e, HttpStatus status, Locale locale) {
        return ExceptionSupport.builder()
                .code(e.getMessage())
                .message(getMessage(e, locale))
                .status(status)
                .build();
    }

    public String getMessage(Exception e, Locale locale) {
        return messageSource.getMessage(e.getMessage(), e.getStackTrace(), locale);
    }
}
