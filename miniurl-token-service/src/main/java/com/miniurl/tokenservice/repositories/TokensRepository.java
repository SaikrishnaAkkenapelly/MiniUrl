package com.miniurl.tokenservice.repositories;

import com.miniurl.tokenservice.entities.ShorteningToken;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/** Interface to abstract basic CRUD operations related to tokens. */
@Repository
public interface TokensRepository extends CassandraRepository<ShorteningToken, Integer> {}
