package com.mudigal.two.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Vijayendra Mudigal
 */

@Data
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "name_value")
public class NameValue {

  @Id
  @Column(name = "original_name", unique = true, nullable = false, columnDefinition = "VARCHAR(12)")
  private String name;

  @Column(name = "original_value", nullable = false, columnDefinition = "VARCHAR(50)")
  private String value;

}
