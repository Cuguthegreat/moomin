package com.example.moomin.exceptions;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {
    private int statusCode;
    private String message;
    private Date timestamp;
}
