package com.miniurl.redirectingservice.service.impl;

import com.miniurl.redirectingservice.entities.LongUrl;
import com.miniurl.redirectingservice.repositories.LongUrlsRepository;
import com.miniurl.redirectingservice.service.ShortUrlMapper;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Implementation class for long URL business operations. */
@Service
public class Base62ShortUrlMapper implements ShortUrlMapper {

  private static final Logger logger = LoggerFactory.getLogger(Base62ShortUrlMapper.class);

  private LongUrlsRepository longUrlsRepository;

  public Base62ShortUrlMapper(LongUrlsRepository longUrlsRepository) {
    this.longUrlsRepository = longUrlsRepository;
  }

  @Override
  public String getMappedUrl(String base62Identifier) throws NoSuchElementException {
    Optional<LongUrl> longUrl = longUrlsRepository.findById(base62Identifier);
    if (longUrl.isPresent()) {
      String url = longUrl.get().getUrl();
      logger.debug("Long url fetched successfully");
      return url;
    } else {
      logger.error("Long url not found for the given short url id {}", base62Identifier);
      throw new NoSuchElementException();
    }
  }
}
