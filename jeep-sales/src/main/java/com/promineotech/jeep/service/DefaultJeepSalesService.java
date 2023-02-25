package com.promineotech.jeep.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineotech.jeep.controller.Jeep;

import lombok.extern.slf4j.Slf4j;
@Service//this got rid of the no such bean error during testing
@Slf4j //Causes lombok to generate a logger field
public class DefaultJeepSalesService implements JeepSalesService {

	@Override
	public List<Jeep> fetchJeeps(String model, String trim) {
		log.info("The fetchJeeps method was called with model={} and trim={}",
				model, trim);
		return null;
	}

}

/*
* annotations have to be at the class level for spring to recognize and use them
* 
*/