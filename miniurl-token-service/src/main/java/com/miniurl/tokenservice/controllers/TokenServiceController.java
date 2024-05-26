package com.miniurl.tokenservice.controllers;

import com.miniurl.tokenservice.constants.TokenServiceConstants;
import com.miniurl.tokenservice.dto.TokenDto;
import com.miniurl.tokenservice.services.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Controller class for the service. */
@RestController
@CrossOrigin
@RequestMapping(TokenServiceConstants.TOKEN_SERVICE_BASE_URI)
public class TokenServiceController {

  private static final Logger logger = LoggerFactory.getLogger(TokenServiceController.class);

  private TokenService tokenService;

  public TokenServiceController(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  /**
   * Issues new token range.
   *
   * @return Response Entity object for token range.
   */
  @GetMapping
  public ResponseEntity<TokenDto> issueTokens() {
    TokenDto tokenDto = tokenService.getToken();
    logger.debug(
        "TokenDto range {} to {} issued", tokenDto.getStartValue(), tokenDto.getEndValue());
    return ResponseEntity.status(HttpStatus.CREATED).body(tokenDto);
  }

  @GetMapping(TokenServiceConstants.TOKEN_SERVICE_LIVENESS_URI)
  public ResponseEntity<String> liveness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }

  @GetMapping(TokenServiceConstants.TOKEN_SERVICE_READINESS_URI)
  public ResponseEntity<String> readiness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }
}
