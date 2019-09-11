package com.springboot.model;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.service.AddressSerializer;

import lombok.Data;

//serializer: java-> json/xml
@Embeddable
@Data
@JsonSerialize(using=AddressSerializer.class)
public class Address {

	int hno;
	String city;
	String state;
	long pincode;
}
