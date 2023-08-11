package com.wouterlefever.stackoverflow.changeset;

import com.wouterlefever.stackoverflow.entity.Person;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@ChangeUnit(id = "person-updater-changeset", order = "1", author = "WLefever")
public class PersonUpdaterChange {

    private final MongoTemplate mongoTemplate;


    public PersonUpdaterChange(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * This is the method with the migration code
     **/
    @Execution
    public void changeSet() {
        //Drop the original index
        mongoTemplate.indexOps(Person.class).dropIndex("unique_name_with_age");
    }

    @RollbackExecution
    public void rollback() {
        // Provide a rollback here
    }
}