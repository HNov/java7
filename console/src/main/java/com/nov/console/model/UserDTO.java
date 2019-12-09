package com.nov.console.model;

import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private Integer age;

    public UserDTO() {

    }

    public UserDTO(String name, Integer age) {
        this();
        this.name = name;
        this.age = age;
    }

}
