package com.generalutils;

import java.util.ArrayList;
import com.validator.BoundaryCheckException;
import com.invalidargumentexception.InvalidArgumentException;

public class GeneralUtils{
	public static void checkObjArgIsNull(Object obj) throws InvalidArgumentException {
		if (obj == null) {
			throw new InvalidArgumentException("Argument cannot be null,pass a valid argument");
		}

	}

	public static void boundaryCheck(int n, int min, int max) throws BoundaryCheckException {
		if (n < min || n>max) {
			throw new BoundaryCheckException(
				"Integer value should be between " + min + " and " + max + " (inclusive) for this operation.");
		}
	}
	
	public static int findLength(CharSequence cs) throws InvalidArgumentException{
        checkObjArgIsNull(cs);
        return cs.length();
    }
	
	public static  String[] split(String str, String delimeter)throws InvalidArgumentException {
		GeneralUtils.checkObjArgIsNull(str);
		GeneralUtils.checkObjArgIsNull(delimeter);
		return str.split(delimeter);
	}
	
	public static String join (String merger,ArrayList<String> strArr)throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(strArr);
		GeneralUtils.checkObjArgIsNull(merger);
		return String.join(merger, strArr);
	}
}