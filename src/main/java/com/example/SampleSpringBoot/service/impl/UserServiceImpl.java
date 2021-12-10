package com.example.SampleSpringBoot.service.impl;

import com.example.SampleSpringBoot.entity.User;
import com.example.SampleSpringBoot.repository.UserRepository;
import com.example.SampleSpringBoot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }
}
