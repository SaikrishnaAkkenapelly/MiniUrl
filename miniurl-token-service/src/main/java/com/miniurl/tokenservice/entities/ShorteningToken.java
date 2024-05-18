package com.miniurl.tokenservice.entities;

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
@Table("shortening_tokens")
@Component
public class ShorteningToken {
	@PrimaryKey
	@Column("token_start_value")
	private int start;
	@Column("token_end_value")
	private int end;
}
