package com.validation.tutorial.resource;

import javax.validation.constraints.*;

public class TestResource {

    @Pattern(regexp = "\\s*\\d*[1-9]+",message = "Should be numeric value")
    private String id;

    @Pattern(regexp = "MR|MRS|MISS", message = "Invalid value")
    private String title;

    @NotBlank(message = "Should not be empty")
    private String name;

    @Min(value = 18, message = "Value should be grater than 17")
    @Max(value = 55, message = "Values should be less that 56")
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
