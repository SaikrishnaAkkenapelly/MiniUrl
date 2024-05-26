package com.miniurl.shorteningservice.services;

import com.miniurl.shorteningservice.constants.ShorteningServiceConstants;
import com.miniurl.shorteningservice.dto.TokenDto;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/** Class to store current token counter to shorten the URL. */
@Component
public class TokenCounter {

  private static final Logger logger = LoggerFactory.getLogger(TokenCounter.class);

  private int start;
  private int end;
  private int current;
  private RestTemplate restTemplate;

  @Value("${tokenservice.url}")
  private String tokenServiceUrl;

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  /**
   * Issues the next token post checking.
   *
   * @return token counter
   */
  public int checkAndIssueToken() {
    if (end - current < ShorteningServiceConstants.TOKEN_COUNTER_RESET_THRESHOLD) {
      CompletableFuture.runAsync(this::updateCounter);
    }
    return current++;
  }

  public void setCurrent(int current) {
    this.current = current;
  }

  public TokenCounter(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /** Updates the token range if exhausting. */
  public void updateCounter() {
    TokenDto tokenDto = restTemplate.getForObject(tokenServiceUrl, TokenDto.class);
    if (tokenDto != null) {
      setStart(tokenDto.getStartValue());
      setCurrent(tokenDto.getStartValue());
      setEnd(tokenDto.getEndValue());
      logger.debug("Token counter updated successfully");
    } else {
      throw new IllegalStateException("Token details from the token service missing");
    }
  }
}
