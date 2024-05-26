package com.miniurl.shorteningservice.repositories;

import com.miniurl.shorteningservice.entities.LongUrl;
import org.springframework.data.cassandra.repository.CassandraRepository;

/** Interface to abstract basic CRUD operations related to long URLs. */
public interface LongUrlsRepository extends CassandraRepository<LongUrl, String> {}
