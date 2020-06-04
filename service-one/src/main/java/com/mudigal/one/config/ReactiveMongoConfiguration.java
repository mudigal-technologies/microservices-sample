package com.mudigal.one.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Profile("default")
@Configuration
public class ReactiveMongoConfiguration
    extends AbstractReactiveMongoConfiguration {

  @Bean
  public ReactiveMongoTemplate mongoTemplate() {
    return new ReactiveMongoTemplate(
        mongoClient(), getDatabaseName());
  }

  @Bean
  public MongoClient mongoClient() {
    return MongoClients.create();
  }

  @Override
  protected String getDatabaseName() {
    return "embeded_db";
  }
}