package com.example.SampleSpringBoot.controller;

import com.example.SampleSpringBoot.dto.request.UserCreateRequest;
import com.example.SampleSpringBoot.dto.response.UserCreateResponse;
import com.example.SampleSpringBoot.entity.User;
import com.example.SampleSpringBoot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private ModelMapper modelMapper;


    @PostMapping("${app.endpoint.userCreate}")
    @CrossOrigin
    public ResponseEntity<Object> registerUser(@Validated @RequestBody UserCreateRequest request) throws Exception{
        User user = modelMapper.map(request, User.class);
        User saveUser = userService.save(user);
        UserCreateResponse userCreateResponse = modelMapper.map(saveUser, UserCreateResponse.class);
        return new ResponseEntity<>(userCreateResponse, HttpStatus.CREATED);
    }
}
