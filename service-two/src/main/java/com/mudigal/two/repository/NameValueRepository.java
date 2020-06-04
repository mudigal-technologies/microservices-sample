package com.mudigal.two.repository;

import com.mudigal.two.domain.NameValue;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Vijayendra Mudigal
 */
@Repository
public interface NameValueRepository extends JpaRepository<NameValue, String> {

  @Query(value = "SELECT nv FROM NameValue nv WHERE name = :name")
  Optional<NameValue> findByName(String name);

}
