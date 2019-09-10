package com.springboot.service;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.springboot.model.Address;

@JsonComponent
public class AddressSerializer extends JsonSerializer<Address>{

	@Override
	public void serialize(Address value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	/*gen.writeStartObject();
		gen.writeStringField(
	          "hno", 
	          value.getHno()+"");
		gen.writeEndObject();*/
		gen.writeString(value.toString());
	}

	

}
