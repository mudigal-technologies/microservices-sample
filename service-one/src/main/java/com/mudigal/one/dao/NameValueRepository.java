package com.mudigal.one.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mudigal.one.domain.NameValue;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
@Repository
public interface NameValueRepository extends ReactiveMongoRepository<NameValue, String> {

}
