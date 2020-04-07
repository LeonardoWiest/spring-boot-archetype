package com.github.util;

/**
 * 
 * @author Leonardo Wiest
 *
 */
public final class IfNull {

	private IfNull() {

	}

	public static final <T> T get(final T value, final T defaultValue) {

		if (value == null) {
			return defaultValue;
		}

		return value;
	}

}
