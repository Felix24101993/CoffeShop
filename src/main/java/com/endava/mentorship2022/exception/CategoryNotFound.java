package com.endava.mentorship2022.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFound extends NestedRuntimeException {

    public CategoryNotFound(String msg){
        super(msg);
    }

}
