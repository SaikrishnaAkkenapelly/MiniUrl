package com.miniurl.redirectingservice.repositories;

import com.miniurl.redirectingservice.entities.LongUrl;
import org.springframework.data.repository.CrudRepository;

public interface LongUrlsRepository extends CrudRepository<LongUrl, String> {}
