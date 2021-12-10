package com.example.SampleSpringBoot.dto.request;

import lombok.Data;

@Data
public class UserCreateRequest {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String contactNumber;

    private String password;
}
