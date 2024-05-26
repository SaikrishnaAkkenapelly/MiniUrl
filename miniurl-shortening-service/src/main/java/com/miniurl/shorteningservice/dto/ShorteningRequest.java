package com.miniurl.shorteningservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Class to store the user's long URL. */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShorteningRequest {
  String longUrl;
}
