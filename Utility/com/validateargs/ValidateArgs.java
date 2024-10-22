package com.validateargs;

import com.validator.BoundaryCheckException;

public class ValidateArgs{
	public void checkObjArgIsNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Argument cannot be null,pass a valid argument");
		}

	}

	public void boundaryCheck(int n, int min, int max) throws BoundaryCheckException {
		try{
			if (n < min || n>max) {
				throw new IllegalArgumentException(
						"Integer value should be between " + min + " and " + max + " (inclusive) for this operation.");
			}
		}
		catch(IllegalArgumentException e){
				throw new BoundaryCheckException("Index hitting the required range ",e);
			
		}
		
	}
}