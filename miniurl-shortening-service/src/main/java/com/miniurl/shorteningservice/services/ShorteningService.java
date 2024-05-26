package com.miniurl.shorteningservice.services;

/** Interface to abstract business operations related to short URLs. */
public interface ShorteningService {

  public String shortenUrl(String longUrl);
}
