package com.wouterlefever.stackoverflow.config;

import io.mongock.driver.api.driver.ConnectionDriver;
import io.mongock.driver.mongodb.springdata.v4.SpringDataMongoV4Driver;
import io.mongock.runner.springboot.EnableMongock;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@EnableConfigurationProperties()
@EnableMongock
public class Config {

	@Bean
	public ConnectionDriver mongockConnection(MongoTemplate mongoTemplate) {
		return SpringDataMongoV4Driver.withDefaultLock(mongoTemplate);
	}

}
