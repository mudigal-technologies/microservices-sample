package com.mudigal.two.mapper;

import com.mudigal.two.domain.NameValue;
import com.mudigal.two.model.NameValueTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Vijayendra Mudigal
 */

@Mapper(componentModel = "spring")
public interface NameValueMapper {

  NameValueMapper INSTANCE = Mappers.getMapper(NameValueMapper.class);

  NameValue getNameValue(NameValueTO nameValueTO);

}
