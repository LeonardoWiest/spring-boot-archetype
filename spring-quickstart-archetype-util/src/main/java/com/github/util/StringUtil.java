package com.github.util;

/**
 * 
 * @author Leonardo Wiest
 *
 */
public final class StringUtil {

	private StringUtil() {

	}

	public static final boolean isNullOrEmpty(final String arg) {

		return IfNull.get(arg, "").equals("");
	}

}
