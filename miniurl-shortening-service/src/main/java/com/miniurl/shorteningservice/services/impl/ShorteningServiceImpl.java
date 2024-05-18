package com.miniurl.shorteningservice.services.impl;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.miniurl.shorteningservice.entities.LongUrl;
import com.miniurl.shorteningservice.repositories.LongUrlsRepository;
import com.miniurl.shorteningservice.services.ShorteningService;
import com.miniurl.shorteningservice.services.TokenCounter;
import com.miniurl.shorteningservice.utils.Base62Encoder;

@Service
public class ShorteningServiceImpl implements ShorteningService {
	private LongUrlsRepository longUrlsRepository;
	private ObjectFactory<LongUrl> longUrlObjectFactory;
	private TokenCounter tokenCounter;
	@Value("${redirectingservice.url}")
	private String shortUrl;

	public ShorteningServiceImpl(ObjectFactory<LongUrl> longUrlObjectFactory, LongUrlsRepository longUrlsRepository,
			TokenCounter tokenCounter) {
		this.longUrlObjectFactory = longUrlObjectFactory;
		this.longUrlsRepository = longUrlsRepository;
		this.tokenCounter = tokenCounter;
	}

	@Override
	public String shortenUrl(String url) {
		int randomInteger = tokenCounter.getCurrent();
		String encodedRandomInteger = Base62Encoder.encode(randomInteger);
		LongUrl longUrl = longUrlObjectFactory.getObject();
		longUrl.setBase62Id(encodedRandomInteger);
		longUrl.setUrl(url);
		longUrlsRepository.insert(longUrl);
		return String.format(shortUrl, encodedRandomInteger);
	}

}
