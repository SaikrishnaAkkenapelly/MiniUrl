package com.miniurl.tokenservice.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.miniurl.tokenservice.entities.ShorteningToken;

@Repository
public interface TokensRepository extends CassandraRepository<ShorteningToken, Integer> {

}
