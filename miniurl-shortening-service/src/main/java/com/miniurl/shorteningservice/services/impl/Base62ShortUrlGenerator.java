package com.miniurl.shorteningservice.services.impl;

import com.miniurl.shorteningservice.entities.LongUrl;
import com.miniurl.shorteningservice.repositories.LongUrlsRepository;
import com.miniurl.shorteningservice.services.ShortUrlGenerator;
import com.miniurl.shorteningservice.services.TokenCounter;
import com.miniurl.shorteningservice.utils.Base62Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/** Implementation class for short URL business operations. */
@Service
public class Base62ShortUrlGenerator implements ShortUrlGenerator {
  private LongUrlsRepository longUrlsRepository;
  private ObjectFactory<LongUrl> longUrlObjectFactory;
  private TokenCounter tokenCounter;

  @Value("${redirectingservice.url}")
  private String shortUrl;

  /**
   * Constructor to initialize the object.
   *
   * @param longUrlObjectFactory LongUrl ObjectFactory
   * @param longUrlsRepository LongUrl Repository
   * @param tokenCounter object to issue the token
   */
  public Base62ShortUrlGenerator(
      ObjectFactory<LongUrl> longUrlObjectFactory,
      LongUrlsRepository longUrlsRepository,
      TokenCounter tokenCounter) {
    this.longUrlObjectFactory = longUrlObjectFactory;
    this.longUrlsRepository = longUrlsRepository;
    this.tokenCounter = tokenCounter;
  }

  @Override
  public String generateShortUrl(String url) {
    int randomInteger = tokenCounter.checkAndIssueToken();
    String encodedRandomInteger = Base62Encoder.encode(randomInteger);
    LongUrl longUrl = longUrlObjectFactory.getObject();
    longUrl.setBase62Id(encodedRandomInteger);
    longUrl.setUrl(url);
    longUrlsRepository.insert(longUrl);
    return String.format(shortUrl, encodedRandomInteger);
  }
}
