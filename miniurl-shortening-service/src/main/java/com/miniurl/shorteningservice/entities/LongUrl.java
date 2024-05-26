package com.miniurl.shorteningservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

/** Class to store the entry from long_urls table in DB. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("long_urls")
@Component
public class LongUrl {
  @PrimaryKey
  @Column("base62_id")
  private String base62Id;

  @Column("url")
  private String url;
}
