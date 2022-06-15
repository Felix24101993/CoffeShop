package com.endava.mentorship2022.exception;

import org.springframework.core.NestedRuntimeException;

public class CategoryNotFound extends NestedRuntimeException {

    public CategoryNotFound(String msg){
        super(msg);
    }

}
