package com.example.healthMonitorDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class MongoDatabaseHealthIndicator implements HealthIndicator {
	
	private static final Logger LOG = LoggerFactory.getLogger(MongoDatabaseHealthIndicator.class);

	private final MongoTemplate mongoTemplate;

	public MongoDatabaseHealthIndicator(MongoTemplate mongoTemplate) {
		Assert.notNull(mongoTemplate, "MongoTemplate must not be null");
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Health health() {
		try {
			this.mongoTemplate.executeCommand("{ buildInfo: 1 }");
			return HealthBuilder.up();
					
		} catch (Exception e) {
			LOG.error("Exception occured :: {}",e);
			return HealthBuilder.down("Database is down.");
		}
	}

}