package com.tarena.service;

/**
 * Created by SkyOne on 2016/10/8.
 */
public class NullParamException extends Exception {
    public NullParamException() {
    }

    public NullParamException(String message) {
        super(message);
    }

    public NullParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullParamException(Throwable cause) {
        super(cause);
    }
}
