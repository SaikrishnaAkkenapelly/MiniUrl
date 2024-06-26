package com.miniurl.shorteningservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/** Configuration class for the service. */
@Configuration
public class ApplicationConfiguration {

  @Bean
  RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
