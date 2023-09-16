package com.validation.tutorial.controller;

import com.validation.tutorial.resource.TestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/validation")
    public ResponseEntity<TestResource> validateTest(@Valid @RequestBody TestResource testResource){
        return new ResponseEntity<>(testResource, HttpStatus.ACCEPTED);
    }
}
