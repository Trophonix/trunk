package com.trophonix.trunk.exceptions;

/**
 * Created by Lucas on 4/12/17.
 */
public class HookRegisterException extends Exception {

    private final String message;

    public HookRegisterException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
