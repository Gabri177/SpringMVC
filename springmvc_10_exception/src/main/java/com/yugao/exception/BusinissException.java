package com.yugao.exception;

import com.yugao.controller.Code;

public class BusinissException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinissException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public BusinissException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
