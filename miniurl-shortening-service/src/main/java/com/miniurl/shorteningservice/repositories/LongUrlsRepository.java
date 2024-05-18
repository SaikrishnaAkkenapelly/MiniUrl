package com.miniurl.shorteningservice.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.miniurl.shorteningservice.entities.LongUrl;

public interface LongUrlsRepository extends CassandraRepository<LongUrl, String> {

}
