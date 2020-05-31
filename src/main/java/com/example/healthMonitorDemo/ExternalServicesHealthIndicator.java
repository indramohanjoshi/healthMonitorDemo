package com.example.healthMonitorDemo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExternalServicesHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		int errorCode = check();
		if (errorCode != 0) {
			return HealthBuilder.down();
		}
		return HealthBuilder.up();
	}

	private int check() {
		// perform some specific health check
		return 503;
	}

}