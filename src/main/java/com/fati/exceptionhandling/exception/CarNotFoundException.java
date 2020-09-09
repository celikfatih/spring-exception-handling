package com.fati.exceptionhandling.exception;

/**
 * author @ fati
 * created @ 7.09.2020
 */

public class CarNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1274005500255477987L;

    private static final String CODE = "EXC-1";

    public CarNotFoundException() {
        super(CODE);
    }
}
