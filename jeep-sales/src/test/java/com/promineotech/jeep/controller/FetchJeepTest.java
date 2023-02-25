package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.http.HttpMethod;

//import com.promineotech.entity.Jeep;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //test random port
@ActiveProfiles("test")//spring boot uses this to look for additional resources before testing
@Sql(scripts = {
		"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
		config = @SqlConfig(encoding = "utf-8")
		)

class FetchJeepTest extends FetchJeepTestSupport{
	
	@Autowired
	//private TestRestTemplate restTemplate;
	@LocalServerPort
	private int serverPort;
	
	@Test //Week 14 homework
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		//Given: a valid model, trim and URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri =
				String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
		
		//When: a connection is made to the URI
		ResponseEntity<List<Jeep>> response =
				getRestTemplate().exchange(uri, HttpMethod.GET, null, 
						new ParameterizedTypeReference<>() {});
		
		//Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And: the actual list returned is the same as the expected list
		List<Jeep> expected = buildExpected();
		System.out.println(expected);
		assertThat(response.getBody()).isEqualTo(expected);
	}
	
//	@Test //from week 13 homework
//	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
//		// Given: a valid model, trim and URI
//		JeepModel model = JeepModel.WRANGLER;
//		String trim = "Sport";
//				/*
//				 * from word document for assignment
//				 * String uri = String.format("http://localhost:%d/jeeps?model=%s&trim=%s",
//			serverPort, model, trim);
//				 */
//		String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim); //from Dr Rob video	
//		// When: a connection is made to the URI
//		ResponseEntity<List<Jeep>> response = 
//				restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
//		//Then: a success (OK - 200) status code is returned
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//	}
	

}

/*
 * Dr Rob video// week 13
 * // Given: a valid model, trim and URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("%s?model=%s&trim=%s", getBaseUri(), model, trim);
		// When: a connection is made to the URI
		
		
		// Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
 */






