package com.avvilenn.student.exceptions;

/**
 * Created by просто on 04.04.2017.
 */
public class GetPropertiesException extends Exception {
    private int code;

    public GetPropertiesException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
