package com.endava.mentorship2022.exception;

import org.springframework.core.NestedRuntimeException;

public class TechnicalDetailNotFound extends NestedRuntimeException {

    public TechnicalDetailNotFound(String msg) { super(msg); }

}
