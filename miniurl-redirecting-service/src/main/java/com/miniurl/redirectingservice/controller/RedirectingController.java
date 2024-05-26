package com.miniurl.redirectingservice.controller;

import com.miniurl.redirectingservice.constants.RedirectingServiceConstants;
import com.miniurl.redirectingservice.service.LongUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/** Controller class for the service. */
@RestController
@CrossOrigin
@RequestMapping(RedirectingServiceConstants.REDIRECTING_SERVICE_BASE_URI)
public class RedirectingController {

  private LongUrlService longUrlService;

  public RedirectingController(LongUrlService longUrlService) {
    this.longUrlService = longUrlService;
  }

  /**
   * Takes the base62Id from the short URL and fetches the respective long URL and redirects to it.
   *
   * @param base62Id string value from short URL
   * @return redirects to the long URL
   */
  @GetMapping("/{value}")
  public RedirectView redirect(@PathVariable("value") String base62Id) {
    String longUrl = longUrlService.fetchLongUrl(base62Id);
    RedirectView redirectView = new RedirectView();
    redirectView.setUrl(longUrl);
    return redirectView;
  }

  @GetMapping(RedirectingServiceConstants.TOKEN_SERVICE_LIVENESS_URI)
  public ResponseEntity<String> liveness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }

  @GetMapping(RedirectingServiceConstants.TOKEN_SERVICE_READINESS_URI)
  public ResponseEntity<String> readiness() {
    return ResponseEntity.status(HttpStatus.OK).body("");
  }
}
