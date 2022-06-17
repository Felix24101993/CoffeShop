package com.endava.mentorship2022.exception;

import org.springframework.core.NestedRuntimeException;

public class UserNotFound extends NestedRuntimeException {

    public UserNotFound(String msg) {
        super(msg);
    }

}