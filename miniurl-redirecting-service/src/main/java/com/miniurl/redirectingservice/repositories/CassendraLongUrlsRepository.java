package com.miniurl.redirectingservice.repositories;

import com.miniurl.redirectingservice.entities.LongUrl;
import org.springframework.data.cassandra.repository.CassandraRepository;

/** Interface to abstract basic CRUD operations related to long URLs. */
public interface CassendraLongUrlsRepository
    extends LongUrlsRepository, CassandraRepository<LongUrl, String> {}
