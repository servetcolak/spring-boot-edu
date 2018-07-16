package com.training.spring.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AdresConverter implements AttributeConverter<Adres, String> {

	@Override
	public String convertToDatabaseColumn(Adres attribute) {
		return attribute.getStreet() + ", " + attribute.getTown() + ", " + attribute.getCity();
	}

	@Override
	public Adres convertToEntityAttribute(String dbData) {
		String[] strs = dbData.split(",");
		Adres adres = new Adres();
		adres.setStreet(strs[0]);
		adres.setTown(strs[1]);
		adres.setCity(strs[2]);
		return adres;
	}

}
