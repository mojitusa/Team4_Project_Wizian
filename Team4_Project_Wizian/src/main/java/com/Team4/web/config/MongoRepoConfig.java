package com.Team4.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.Team4.web.mongodbrepository")
public class MongoRepoConfig {
}


