package com.miniurl.shorteningservice.controllers;

import com.miniurl.shorteningservice.constants.ShorteningServiceConstants;
import com.miniurl.shorteningservice.dto.ShorteningRequest;
import com.miniurl.shorteningservice.services.ShorteningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller class for the service. */
@RestController
@CrossOrigin
@RequestMapping(ShorteningServiceConstants.SHORTENING_SERVICE_BASE_URI)
public class ShorteningController {

  private static final Logger logger = LoggerFactory.getLogger(ShorteningController.class);

  private ShorteningService shorteningService;

  public ShorteningController(ShorteningService shorteningService) {
    this.shorteningService = shorteningService;
  }

  /**
   * Takes the user input long URL and gives out the respective short URL.
   *
   * @param shorteningRequest object to stores input long URL
   * @return short URL for the given long URL
   */
  @PostMapping
  public ResponseEntity<String> getShortUrl(@RequestBody ShorteningRequest shorteningRequest) {
    String shortUrl = shorteningService.shortenUrl(shorteningRequest.getLongUrl());
    logger.debug("Short URL for : {} is : {}", shorteningRequest.getLongUrl(), shortUrl);
    return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
  }

  @GetMapping(ShorteningServiceConstants.TOKEN_SERVICE_LIVENESS_URI)
  public ResponseEntity<String> liveness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }

  @GetMapping(ShorteningServiceConstants.TOKEN_SERVICE_READINESS_URI)
  public ResponseEntity<String> readiness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }
}
