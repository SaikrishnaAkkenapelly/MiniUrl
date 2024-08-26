package com.miniurl.redirectingservice.service;

import java.util.NoSuchElementException;

/** Interface to abstract business operations related to long URLs. */
public interface ShortUrlMapper {

  public String getMappedUrl(String identifier) throws NoSuchElementException;
}
