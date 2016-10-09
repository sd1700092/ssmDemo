package com.tarena.service;

/**
 * Created by SkyOne on 2016/10/8.
 */
public class NameOrPwdException extends Exception {
    public NameOrPwdException() {
    }

    public NameOrPwdException(String message) {
        super(message);
    }

    public NameOrPwdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameOrPwdException(Throwable cause) {
        super(cause);
    }
}
