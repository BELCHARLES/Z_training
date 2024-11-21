package com.task;

import java.util.ArrayList;
import com.generalutils.GeneralUtils;
import com.validator.BoundaryCheckException;
import com.invalidargumentexception.InvalidArgumentException;
import com.stringbuilderexception.StringBuilderException;

public class StringBuilderTask{
	
	public StringBuilder getStringBuilder(){
		return new StringBuilder();
	}
	
	public StringBuilder getStringBuilder(ArrayList<String> strArr ,String delimiter)
	throws InvalidArgumentException{
		String str = GeneralUtils.join(delimiter,strArr);
		return new StringBuilder(str);
	}
	
	
	public StringBuilder appendWithDelimiter(StringBuilder strBuilder ,String delimiter, ArrayList<String> strArr)
	throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(strBuilder);
		String str = GeneralUtils.join(delimiter,strArr);
		return strBuilder.append(delimiter).append(str);
	}
	
	//helper function
	private int findStartIndex (int operationAt , String delimiter , String [] strArr){
		int currentIndex = 0; 
		int startIndex = 0;  
		for (int i = 0; i < operationAt; i++) {
			startIndex = currentIndex; 
			currentIndex += strArr[i].length();
			if (i < strArr.length - 1) {
				currentIndex += delimiter.length(); 
			}
		}
		return startIndex;
	}
	
	public StringBuilder insertString (int insertAfter ,String delimiter, String insertText,StringBuilder strBuilder)
	throws InvalidArgumentException,StringBuilderException {
		try{
			//sanity checks
			GeneralUtils.checkObjArgIsNull(insertText);
			GeneralUtils.checkObjArgIsNull(strBuilder);
			String strArr[] = GeneralUtils.split(strBuilder.toString(),delimiter);
			GeneralUtils.checkObjArgIsNull(strArr);
			int strArrLength = strArr.length;
			GeneralUtils.boundaryCheck(insertAfter,1,strArrLength);
			//insert at last case
			if(insertAfter == strArrLength){
				int insertAt = GeneralUtils.findLength(strBuilder);
				return strBuilder.insert(insertAt,delimiter+insertText);
			}
			//insert anywhere except that of last 
			StringBuilderTask task = new StringBuilderTask();
			int insertAt = task.findStartIndex(insertAfter+1 , delimiter , strArr);
			return strBuilder.insert(insertAt, insertText + delimiter);
		}
		catch(BoundaryCheckException e){
			throw new StringBuilderException("Index out of range in method insertString",e);
		}
	}
	
	public StringBuilder delete (int startIndex ,int endIndex,StringBuilder strBuilder)
	throws InvalidArgumentException,StringBuilderException{
		try{
			int strBuilderLength = GeneralUtils.findLength(strBuilder);
			GeneralUtils.boundaryCheck(startIndex, 0 , strBuilderLength-1);
			GeneralUtils.boundaryCheck(endIndex ,startIndex+1 ,strBuilderLength);
			return strBuilder.delete(startIndex,endIndex);
		}
		catch(BoundaryCheckException e){
			throw new StringBuilderException("StartIndex range(inclusive): 0 to strBuilderLength-1\nEndIndex range(inclusive):startIndex to strBuilderLength",e);
		}
	}
	
	public StringBuilder deleteString(int deleteStrAt,String delimiter,StringBuilder strBuilder)
	throws InvalidArgumentException,StringBuilderException{
		try{
			GeneralUtils.checkObjArgIsNull(strBuilder);
			String strArr[] = GeneralUtils.split(strBuilder.toString(),delimiter);
			GeneralUtils.checkObjArgIsNull(strArr);
			GeneralUtils.boundaryCheck(deleteStrAt,1,strArr.length);
			StringBuilderTask task = new StringBuilderTask();
			int startIndex = task.findStartIndex(deleteStrAt,delimiter,strArr);
			int endIndex = startIndex + strArr[deleteStrAt - 1].length(); 
			if (endIndex < strBuilder.length() && 
			strBuilder.substring(endIndex, endIndex + delimiter.length()).equals(delimiter)) {
				endIndex += delimiter.length(); 
			}
			return task.delete(startIndex,endIndex,strBuilder);
		}
		catch(BoundaryCheckException e){
			throw new StringBuilderException("The string to delete is not within expected range",e);
		}
	}
	
	public StringBuilder replace (int startIndex ,int endIndex, String replaceWith,StringBuilder strBuilder)
	throws InvalidArgumentException,StringBuilderException{
		try{
			GeneralUtils.checkObjArgIsNull(replaceWith);
			int strBuilderLength = GeneralUtils.findLength(strBuilder);
			GeneralUtils.boundaryCheck(startIndex, 0 , strBuilderLength-1);
			GeneralUtils.boundaryCheck(endIndex ,startIndex+1 ,strBuilderLength);
			return strBuilder.replace(startIndex,endIndex,replaceWith);
		}
		catch(BoundaryCheckException e){
			throw new StringBuilderException("StartIndex range(inclusive): 0 to strBuilderLength-1\nEndIndex range(inclusive):startIndex to strBuilderLength",e);
		}
	}
	
	public StringBuilder replaceString(String toReplace , String replaceWith , StringBuilder strBuilder)
	throws InvalidArgumentException,StringBuilderException{
		int toReplaceLength = GeneralUtils.findLength(toReplace);
		StringBuilderTask task = new StringBuilderTask();
		int startIndex = task.findIndex(toReplace,strBuilder,true);
		while ( startIndex != -1){
			int endIndex = startIndex + toReplaceLength;
			strBuilder = task.replace(startIndex,endIndex,replaceWith,strBuilder);
			startIndex = task.findIndex(toReplace,strBuilder,true);
		}
		return strBuilder;
	}
	
	public StringBuilder reverse (StringBuilder strBuilder)
	throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(strBuilder);
		return strBuilder.reverse();
	}
	
	public int findIndex ( String str,StringBuilder strBuilder, Boolean isFirst)
	throws InvalidArgumentException{
		GeneralUtils.checkObjArgIsNull(str);
		GeneralUtils.checkObjArgIsNull(strBuilder);
		if(isFirst){
			return strBuilder.indexOf(str);
		}
		return strBuilder.lastIndexOf(str);
	}
}