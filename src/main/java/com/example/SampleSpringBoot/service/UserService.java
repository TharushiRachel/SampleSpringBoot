package com.example.SampleSpringBoot.service;

import com.example.SampleSpringBoot.entity.User;

public interface UserService {

    User save(User user) throws Exception;
}
