package com.validation.tutorial.exeption;

import com.validation.tutorial.resource.TestResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;

@RestControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Field sField;

        try {
            String className = ex.getBindingResult().getObjectName();
            switch (className) {

                case "testResource":
                    TestResource testResource = new TestResource();
                    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                        sField = testResource.getClass().getDeclaredField(error.getField());
                        sField.setAccessible(true);
                        sField.set(testResource.getClass().cast(testResource), error.getDefaultMessage());

                    }
                    return new ResponseEntity<>(testResource, HttpStatus.UNPROCESSABLE_ENTITY);

                default:
                    return new ResponseEntity<>("", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
