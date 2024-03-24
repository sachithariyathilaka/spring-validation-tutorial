package io.github.sachithariyathilaka.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * Validate resource for the rest endpoint request body.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ValidateResource {

    @Pattern(regexp = "\\s*\\d*[1-9]+",message = "Should be numeric value")
    private String id;

    @Pattern(regexp = "MR|MRS|MISS", message = "Invalid value")
    private String title;

    @NotBlank(message = "Should not be empty")
    private String name;

    @Min(value = 18, message = "Value should be grater than 17")
    @Max(value = 55, message = "Values should be less that 56")
    private String age;
}
