package com.example.mySite;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found")
public class DataNotFoundException extends Throwable {
    public DataNotFoundException (String message) {
        super(message);
    }
}
