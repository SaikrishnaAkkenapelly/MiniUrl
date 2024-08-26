package com.miniurl.shorteningservice.services;

/** Interface to abstract business operations related to short URLs. */
public interface ShortUrlGenerator {

  public String generateShortUrl(String longUrl);
}
