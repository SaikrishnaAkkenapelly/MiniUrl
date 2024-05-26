package com.miniurl.tokenservice.services.impl;

import com.miniurl.tokenservice.constants.TokenServiceConstants;
import com.miniurl.tokenservice.dto.TokenDto;
import com.miniurl.tokenservice.entities.ShorteningToken;
import com.miniurl.tokenservice.repositories.TokensRepository;
import com.miniurl.tokenservice.services.TokenService;
import java.util.List;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/** Implementation class for tokens operations. */
@Service
public class TokenServiceImpl implements TokenService {

  private TokensRepository tokensRepository;
  private ObjectFactory<ShorteningToken> shorteningTokenObjectFactory;
  private ObjectFactory<TokenDto> tokenObjectFactory;

  /**
   * Constructor to initialize this class.
   *
   * @param tokensRepository Object to interact with DB
   * @param shorteningTokenObjectFactory Object to issue new tokens to shortening service
   * @param tokenObjectFactory Object to issue new tokens in DB
   */
  public TokenServiceImpl(
      TokensRepository tokensRepository,
      ObjectFactory<ShorteningToken> shorteningTokenObjectFactory,
      ObjectFactory<TokenDto> tokenObjectFactory) {
    this.tokensRepository = tokensRepository;
    this.shorteningTokenObjectFactory = shorteningTokenObjectFactory;
    this.tokenObjectFactory = tokenObjectFactory;
  }

  @Override
  public TokenDto getToken() {
    List<ShorteningToken> allTokens = tokensRepository.findAll();
    if (CollectionUtils.isEmpty(allTokens)) {
      ShorteningToken shorteningToken = getShorteningToken(TokenServiceConstants.TOKEN_START_VALUE);
      tokensRepository.insert(shorteningToken);
      return getToken(shorteningToken);
    } else {
      int endValue = Integer.MIN_VALUE;
      for (ShorteningToken shorteningToken : allTokens) {
        endValue = Math.max(endValue, shorteningToken.getEnd());
      }
      endValue++;
      ShorteningToken shorteningToken = getShorteningToken(endValue);
      tokensRepository.insert(shorteningToken);
      return getToken(shorteningToken);
    }
  }

  /**
   * Gives the object containing the token start and end values.
   *
   * @param range object containing issued range
   * @return object with updated ranges
   */
  private TokenDto getToken(ShorteningToken range) {
    TokenDto tokenDto = tokenObjectFactory.getObject();
    tokenDto.setStartValue(range.getStart());
    tokenDto.setEndValue(range.getEnd());
    return tokenDto;
  }

  private ShorteningToken getShorteningToken(int startValue) {
    ShorteningToken shorteningToken = shorteningTokenObjectFactory.getObject();
    shorteningToken.setStart(startValue);
    shorteningToken.setEnd(startValue + TokenServiceConstants.TOKEN_INCREMENT_VALUE);
    return shorteningToken;
  }
}
