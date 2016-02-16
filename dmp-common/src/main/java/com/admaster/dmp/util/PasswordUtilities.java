package com.admaster.dmp.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class PasswordUtilities {
	private static final String SALT = "5OGP56W65A6D6LSD";

	public static String md5(String password) {
		if (StringUtils.isBlank(password))
			return null;

		if (password.length() == 32 && password.toLowerCase().matches("^[0-9a-f]+$")) {
			return password.toLowerCase();
		} else {
			return DigestUtils.md5Hex(password);
		}
	}

	public static String encrypt(String password) {
		if (StringUtils.isBlank(password))
			return null;

		return DigestUtils.md5Hex(md5(password) + SALT) + 'x';
	}
}
