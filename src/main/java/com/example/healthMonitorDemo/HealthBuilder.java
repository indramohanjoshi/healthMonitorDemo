package com.example.healthMonitorDemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;

public class HealthBuilder {
	
	private static final String CUSTOM_RESPONSE_MESSAGE = "customResponseMessage";
	private static final String RESPONSE_MESSAGE = "responseMessage";
	private static final String RESPONSE_CODE = "responseCode";
	private static final String DEFAULT_CUSTOM_RESPONSE_MESSAGE = "NA";

	public static Health up() {
		return Health.up()
		.withDetail(RESPONSE_CODE, HttpStatus.OK.value())
		.withDetail(RESPONSE_MESSAGE, HttpStatus.OK.name())
		.withDetail(CUSTOM_RESPONSE_MESSAGE, DEFAULT_CUSTOM_RESPONSE_MESSAGE)
		.build();
	}
	
	public static Health up(String customMessage) {
		return Health.up()
		.withDetail(RESPONSE_CODE, HttpStatus.OK.value())
		.withDetail(RESPONSE_MESSAGE, HttpStatus.OK.name())
		.withDetail(CUSTOM_RESPONSE_MESSAGE, customMessage)
		.build();
	}
	
	public static Health down() {
		return Health.down()
				.withDetail(RESPONSE_CODE, HttpStatus.SERVICE_UNAVAILABLE.value())
				.withDetail(RESPONSE_MESSAGE, HttpStatus.SERVICE_UNAVAILABLE.name())
				.withDetail(CUSTOM_RESPONSE_MESSAGE, DEFAULT_CUSTOM_RESPONSE_MESSAGE)
				.build();
	}
	
	public static Health down(String customMessage) {
		return Health.down()
				.withDetail(RESPONSE_CODE, HttpStatus.SERVICE_UNAVAILABLE.value())
				.withDetail(RESPONSE_MESSAGE, HttpStatus.SERVICE_UNAVAILABLE.name())
				.withDetail(CUSTOM_RESPONSE_MESSAGE, customMessage)
				.build();
	}

}
