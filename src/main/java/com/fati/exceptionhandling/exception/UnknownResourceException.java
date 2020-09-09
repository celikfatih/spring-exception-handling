package com.fati.exceptionhandling.exception;

/**
 * author @ fati
 * created @ 10.08.2020
 */

public class UnknownResourceException extends RuntimeException {

    private static final long serialVersionUID = 7305585583504908893L;

    public UnknownResourceException(String s) {
        super(s);
    }
}
