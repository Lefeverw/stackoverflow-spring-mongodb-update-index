package com.wouterlefever.stackoverflow.entity;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@CompoundIndex(
        name = "unique_name_with_age",
        def = "{ 'firstName':1 , 'lastName':1 }",
        unique = true)
//@CompoundIndex(
//        name = "unique_name_with_age",
//        def = "{ 'firstName':1 , 'lastName':1, 'ssn':1 }",
//        unique = true)
@Document
public class Person {
    private final String firstName;
    private final String lastName;
    private final String ssn;

    public Person(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }
}
