package com.miniurl.shorteningservice.utils;

public class Base62Encoder {

	private static final String BASE62_CHAR_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private Base62Encoder() {
	}

	public static String encode(int input) {
		StringBuilder encodedString = new StringBuilder();
		do {
			encodedString.append(BASE62_CHAR_SET.charAt(input % BASE62_CHAR_SET.length()));
			input = input / BASE62_CHAR_SET.length();
		} while (input > 0);
		return encodedString.reverse().toString();
	}

}
