package com.mudigal.two.dao;

import org.springframework.data.repository.CrudRepository;
import com.mudigal.two.domain.NameValue;

/**
 * 
 * @author Vijayendra Mudigal
 *
 */
public interface NameValueDao extends CrudRepository<NameValue, Long> {

}
