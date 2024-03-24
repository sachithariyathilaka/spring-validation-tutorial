package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.resource.APIResponse;
import io.github.sachithariyathilaka.resource.ValidateResource;
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
@RequestMapping("/api/validation")
public class ValidateController {

    /**
     * Validate endpoint for validate the spring boot validations.
     *
     * @param   validateResource the validate resource
     *
     * @return  the api response
     */
    @PostMapping("/")
    public ResponseEntity<APIResponse<ValidateResource>> validation(@Valid @RequestBody ValidateResource validateResource){
        APIResponse<ValidateResource> apiResponse = new APIResponse<>(200, "API request validated!", validateResource);
        return new ResponseEntity<>(apiResponse, HttpStatus.ACCEPTED);
    }
}
