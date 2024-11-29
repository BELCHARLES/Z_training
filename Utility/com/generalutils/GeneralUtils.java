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
	
	public static int findStartIndex (int operationAt , String delimiter , StringBuilder strBuilder,Boolean isInsert)
	throws InvalidArgumentException,BoundaryCheckException{
		GeneralUtils.checkObjArgIsNull(delimiter);
		if (operationAt < 1){
			throw new BoundaryCheckException("The string to operate cannot be negative");
		}
		int count = 0;
		int delIndex=0;
		char delimiterChar = delimiter.charAt(0); 
		int length = GeneralUtils.findLength(strBuilder);
		for(int i =0 ; i<length ; i++){
			if(strBuilder.charAt(i)== delimiterChar){
				count++;
				if(count == operationAt){
					if (isInsert) {
						return i + 1;
					}
					return delIndex;
				}
				delIndex = i+1;
			}
		}
		if (!isInsert && count < operationAt) {
			throw new BoundaryCheckException("The position to operate exceeds the number of strings	");
        }
		return length;	
	}
	
	public static int findEndIndex (int startIndex,String delimiter,StringBuilder strBuilder)
	throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(strBuilder);
		GeneralUtils.checkObjArgIsNull(delimiter);
		int eofDelimiter = strBuilder.indexOf(delimiter,startIndex)+GeneralUtils.findLength(delimiter);
		int endIndex = startIndex+(eofDelimiter-startIndex);
		return endIndex;
	}
	
	public static int findIndexInStrBuilder ( String str,StringBuilder strBuilder, Boolean isFirst)
	throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(str);
		GeneralUtils.checkObjArgIsNull(strBuilder);
		if(isFirst){
			return strBuilder.indexOf(str);
		}
		return strBuilder.lastIndexOf(str);
	}
	
	public static StringBuilder deleteInStrBuilder (int startIndex ,int endIndex,StringBuilder strBuilder)
	throws InvalidArgumentException,BoundaryCheckException{
		int strBuilderLength = GeneralUtils.findLength(strBuilder);
		GeneralUtils.boundaryCheck(startIndex, 0 , strBuilderLength-1);
		GeneralUtils.boundaryCheck(endIndex ,startIndex+1 ,strBuilderLength);
		return strBuilder.delete(startIndex,endIndex);
	}
	
	public static StringBuilder replaceInStrBuilder (int startIndex ,int endIndex, String replaceWith,StringBuilder strBuilder)
	throws InvalidArgumentException,BoundaryCheckException{
		GeneralUtils.checkObjArgIsNull(replaceWith);
		int strBuilderLength = GeneralUtils.findLength(strBuilder);
		GeneralUtils.boundaryCheck(startIndex, 0 , strBuilderLength-1);
		GeneralUtils.boundaryCheck(endIndex ,startIndex+1 ,strBuilderLength);
		return strBuilder.replace(startIndex,endIndex,replaceWith);
	}
}

//startindex logic for string delimiter
//int count = 0;
//		int startIndex = 0;
//		int delimiterLength = GeneralUtils.findLength(delimiter);
//		int index = strBuilder.indexOf(delimiter , startIndex);
//		int flag = 0;//to check operationAt is greater than no.of strings
//		while(index!= -1){
//			count++;
//			if(count == operationAt){
//				flag =1;
//				break;
//			}
//			startIndex = index+delimiterLength;
//			index = strBuilder.indexOf(delimiter , startIndex);
//		}
//		if(!isInsert && flag == 0){
//			throw new BoundaryCheckException("String number is greater than the number of strings ");
//		}
//		return startIndex;