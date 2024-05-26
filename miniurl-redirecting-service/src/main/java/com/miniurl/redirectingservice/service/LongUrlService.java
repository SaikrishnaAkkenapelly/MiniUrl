package com.miniurl.redirectingservice.service;

import java.util.NoSuchElementException;

/** Interface to abstract business operations related to long URLs. */
public interface LongUrlService {

  public String fetchLongUrl(String base62Id) throws NoSuchElementException;
}
