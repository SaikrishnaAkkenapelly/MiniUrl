package com.miniurl.redirectingservice.service.impl;

import com.miniurl.redirectingservice.entities.LongUrl;
import com.miniurl.redirectingservice.repositories.LongUrlsRepository;
import com.miniurl.redirectingservice.service.LongUrlService;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Implementation class for long URL business operations. */
@Service
public class LongUrlFetchingServiceImpl implements LongUrlService {

  private static final Logger logger = LoggerFactory.getLogger(LongUrlFetchingServiceImpl.class);

  private LongUrlsRepository longUrlsRepository;

  public LongUrlFetchingServiceImpl(LongUrlsRepository longUrlsRepository) {
    this.longUrlsRepository = longUrlsRepository;
  }

  @Override
  public String fetchLongUrl(String base62Id) throws NoSuchElementException {
    Optional<LongUrl> longUrl = longUrlsRepository.findById(base62Id);
    if (longUrl.isPresent()) {
      String url = longUrl.get().getUrl();
      logger.debug("Long url fetched successfully");
      return url;
    } else {
      logger.error("Long url not found for the given short url id {}", base62Id);
      throw new NoSuchElementException();
    }
  }
}
