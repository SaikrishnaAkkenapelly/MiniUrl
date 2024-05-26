package com.miniurl.tokenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/** Class to store the token range. */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TokenDto {
  private int startValue;
  private int endValue;
}
