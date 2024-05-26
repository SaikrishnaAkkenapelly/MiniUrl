package com.miniurl.tokenservice.services;

import com.miniurl.tokenservice.dto.TokenDto;

/** Interface to abstract business operations related to tokens. */
public interface TokenService {

  TokenDto getToken();
}
