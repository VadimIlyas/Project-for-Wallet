package com.javacode.project.exception;

import com.javacode.project.dto.OperationDto;

public class InvalidOperationTypeException extends RuntimeException {

    public InvalidOperationTypeException(String message) {
        super(message);
    }

    public InvalidOperationTypeException(OperationDto operationDto) {
        super("Invalid type of operation: " + operationDto.getType());
    }

}
