package com.miniurl.shorteningservice.configurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.miniurl.shorteningservice.constants.ShorteningServiceConstants;

@Configuration
public class CassandraConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(CassandraConfiguration.class);

	@Value("${spring.cassandra.keyspace-name}")
	private String keySpaceName;
	@Value("${spring.cassandra.config}")
	private String cassandraConfig;

	@Bean
	@Profile("local")
	CqlSession getLocalCqlSession() {
		logger.debug("Creating Local CQLSession");
		return CqlSession.builder().withKeyspace(keySpaceName).build();
	}

	@Bean
	@Profile("aws")
	CqlSession getAwsCqlSession() {
		logger.debug("Creating AWS CQLSession");
		DriverConfigLoader configLoader = DriverConfigLoader.fromClasspath(cassandraConfig
				.replace(ShorteningServiceConstants.FILE_PREFIX, ShorteningServiceConstants.EMPTY_STRING));
		return CqlSession.builder().withConfigLoader(configLoader).withKeyspace(keySpaceName).build();
	}

}
