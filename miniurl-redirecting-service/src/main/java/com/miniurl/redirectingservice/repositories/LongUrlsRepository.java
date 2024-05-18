package com.miniurl.redirectingservice.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.miniurl.redirectingservice.entities.LongUrl;

public interface LongUrlsRepository extends CassandraRepository<LongUrl, String> {

}
