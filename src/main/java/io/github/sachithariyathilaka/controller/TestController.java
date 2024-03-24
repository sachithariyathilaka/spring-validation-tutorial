package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.resource.TestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller layer for the organize rest endpoints.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * Test endpoint for validate the spring boot validations.
     *
     * @param   testResource the test resource
     *
     * @return  the test resource
     */
    @PostMapping("/validation")
    public ResponseEntity<TestResource> validateTest(@Valid @RequestBody TestResource testResource){
        return new ResponseEntity<>(testResource, HttpStatus.ACCEPTED);
    }
}
