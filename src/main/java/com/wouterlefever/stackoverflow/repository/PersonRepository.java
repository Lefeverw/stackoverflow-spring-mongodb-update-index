package com.wouterlefever.stackoverflow.repository;

import com.wouterlefever.stackoverflow.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
