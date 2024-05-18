package com.miniurl.redirectingservice.entities;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
