package com.miniurl.redirectingservice.service;

import java.util.NoSuchElementException;

public interface LongUrlFetchingService {

	public String fetchLongUrl(String base62Id) throws NoSuchElementException;

}
