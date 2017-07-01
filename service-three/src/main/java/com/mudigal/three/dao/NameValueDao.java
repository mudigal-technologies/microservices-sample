package com.mudigal.three.dao;

import org.springframework.data.repository.CrudRepository;
import com.mudigal.three.domain.NameValue;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
public interface NameValueDao extends CrudRepository<NameValue, Long> {

}
