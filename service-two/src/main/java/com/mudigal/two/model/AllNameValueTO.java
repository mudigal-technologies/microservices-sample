package com.mudigal.two.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * @author Vijayendra Mudigal
 */
@Data
public class AllNameValueTO {

  private String originalName;
  private String originalValue;
  private Map<String, String> remainingNameValuePair = new HashMap<>();

}
