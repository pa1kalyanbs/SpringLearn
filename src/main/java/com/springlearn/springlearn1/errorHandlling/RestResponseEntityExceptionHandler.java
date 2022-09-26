package com.springlearn.springlearn1.errorHandlling;

import com.springlearn.springlearn1.entity.ErrorMassege;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentErrorHandlling.class)
    public ResponseEntity<ErrorMassege> departmentNotFound(DepartmentErrorHandlling errorHandlling ,
                                                           WebRequest request){

        ErrorMassege message = new ErrorMassege(HttpStatus.NOT_FOUND,errorHandlling.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);

    }
}
