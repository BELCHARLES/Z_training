package com.validateargs;

import com.validator.BoundaryCheckException;

public class ValidateArgs{
	public static void checkObjArgIsNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Argument cannot be null,pass a valid argument");
		}

	}

	public static void boundaryCheck(int n, int min, int max) throws BoundaryCheckException {
		if (n < min || n>max) {
			throw new BoundaryCheckException(
				"Integer value should be between " + min + " and " + max + " (inclusive) for this operation.");
		}
	}
}