package com.task;

import com.stringtaskexception.StringTaskException;
import com.validator.BoundaryCheckException;
import com.validateargs.ValidateArgs;

public class StringTask {
	public int findLength(String str) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.length();
	}

	public char[] convertToCharArray(String str) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.toCharArray();
	}

	public char charAtPos(String str, int pos) throws StringTaskException {
		try{
			ValidateArgs.boundaryCheck(pos, 1, findLength(str));
			return str.charAt(pos - 1);
		}
		catch(BoundaryCheckException e){
			throw new StringTaskException("Index out of range in method charAtPos",e);
		}
	}

	public int countOfChar(String str, char letter) {
		int count = 0;
		int length = findLength(str);
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}

	public int greatestPosOfChar(String str, char letter) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.lastIndexOf(letter);
	}

	public String getLastNChar(String str, int n) throws StringTaskException {
		try{
			int length = findLength(str);
			ValidateArgs.boundaryCheck(n, 1, length);
			return str.substring(length - n);
		}
		catch(BoundaryCheckException e){
			throw new StringTaskException("Index out of range in method getLastNChar",e);
		}	
	}

	public String getFirstNChar(String str, int n) throws StringTaskException {
		try{
			ValidateArgs.boundaryCheck(n, 1, findLength(str));
			return str.substring(0, n);
		}
		catch(BoundaryCheckException e){
			throw new StringTaskException("Index out of range in method getFirstNChar",e);
		}
		
	}

	public String replaceFirstNChar(String str, int count, String repStr) throws StringTaskException {
		try{
			ValidateArgs.checkObjArgIsNull(repStr);
			ValidateArgs.boundaryCheck(count, 1, findLength(str));
			return repStr.concat(str.substring(count));
		}
		catch(BoundaryCheckException e){
			throw new StringTaskException("Index out of range in method replaceFirstNChar",e);
		}
	}

	public boolean checkStartsWith(String str, String starter) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(starter);
		return str.startsWith(starter);
	}

	public boolean checkEndsWith(String str, String ender) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(ender);
		return str.endsWith(ender);
	}

	public String changeCase(String str,boolean toUpper) {
		ValidateArgs.checkObjArgIsNull(str);
		if(toUpper){
			return str.toUpperCase();
		}
		return str.toLowerCase();
	}

	public String reverseString(String str) {
		char[] charArr = convertToCharArray(str);
		int left = 0;
		int right = findLength(str) - 1;
		while (left < right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] = temp;
			left++;
			right--;
		}
		return new String(charArr);
	}

	public String concWithoutGivenChar(String str, String remover,String replacer) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(remover);
		ValidateArgs.checkObjArgIsNull(replacer);
		return str.replace(remover, replacer);
	}

	public String[] split(String str, String delimeter) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(delimeter);
		return str.split(delimeter);
	}

	public String mergeStrWithChar(String[] strArr, String merger) {
		ValidateArgs.checkObjArgIsNull(strArr);
		ValidateArgs.checkObjArgIsNull(merger);
		return String.join(merger, strArr);
	}

	public boolean equalsWithCaseOption(String str1, String str2,boolean isCaseSensitive) {
		ValidateArgs.checkObjArgIsNull(str1);
		ValidateArgs.checkObjArgIsNull(str2);
		if (isCaseSensitive){
			return str1.equals(str2);
		}
		return str1.equalsIgnoreCase(str2);
	}

	public String trimExtraSpace(String str) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.trim();
	}

}