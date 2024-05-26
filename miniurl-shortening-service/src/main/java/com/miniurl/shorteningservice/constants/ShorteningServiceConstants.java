package com.miniurl.shorteningservice.constants;

/** Constants class for the service. */
public class ShorteningServiceConstants {

  private ShorteningServiceConstants() {}

  public static final String SHORTENING_SERVICE_BASE_URI = "/shorten";
  public static final String TOKEN_SERVICE_LIVENESS_URI = "/liveness";
  public static final String TOKEN_SERVICE_READINESS_URI = "/readiness";
  public static final int TOKEN_COUNTER_RESET_THRESHOLD = 100;
  public static final String FILE_PREFIX = "file:";
  public static final String EMPTY_STRING = "";
}
