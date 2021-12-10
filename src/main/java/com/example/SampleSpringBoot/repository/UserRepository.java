package com.example.SampleSpringBoot.repository;

import com.example.SampleSpringBoot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, String> {
}
