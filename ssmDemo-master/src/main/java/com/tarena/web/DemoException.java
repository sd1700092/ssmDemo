package com.tarena.web;

/**
 * Created by SkyOne on 2016/10/8.
 */
public class DemoException extends Exception {
    public DemoException() {
    }

    public DemoException(String message) {
        super(message);
    }

    public DemoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DemoException(Throwable cause) {
        super(cause);
    }
}
