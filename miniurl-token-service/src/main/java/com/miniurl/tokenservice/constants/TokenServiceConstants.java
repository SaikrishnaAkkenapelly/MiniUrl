package com.miniurl.tokenservice.constants;

public class TokenServiceConstants {

	private TokenServiceConstants() {
	}

	public static final String TOKEN_SERVICE_BASE_URI = "/token";
	public static final String TOKEN_SERVICE_LIVENESS_URI = "/liveness";
	public static final String TOKEN_SERVICE_READINESS_URI = "/readiness";
	public static final int TOKEN_START_VALUE = 10000;
	public static final int TOKEN_INCREMENT_VALUE = 999;
	public static final String FILE_PREFIX = "file:";
	public static final String EMPTY_STRING = "";

}
