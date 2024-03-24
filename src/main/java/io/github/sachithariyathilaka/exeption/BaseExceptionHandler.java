package io.github.sachithariyathilaka.exeption;

import io.github.sachithariyathilaka.resource.TestResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Field;

/**
 * Rest controller adviser for validate rest endpoints.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@RestControllerAdvice
public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Override method for handle rest endpoint resource validations.
     *
     * @param   ex the method argument not valid exception
     * @param   headers the http headers
     * @param   status the http status
     * @param   request the web request
     *
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        Field sField;

        try {
            String className = ex.getBindingResult().getObjectName();

            if (className.equals("testResource")) {
                TestResource testResource = new TestResource();
                for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                    sField = testResource.getClass().getDeclaredField(error.getField());
                    sField.setAccessible(true);
                    sField.set(testResource.getClass().cast(testResource), error.getDefaultMessage());

                }
                return new ResponseEntity<>(testResource, HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>("", HttpStatus.UNPROCESSABLE_ENTITY);

        } catch (Exception e) {
            return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
