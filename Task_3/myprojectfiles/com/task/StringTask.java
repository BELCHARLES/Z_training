package com.task;

import com.exception.*;

public class StringTask {
	public int findLength(String str) {
		checkObjArgIsNull(str);
		return str.length();
	}

	public char[] convertToCharArray(String str) {
		checkObjArgIsNull(str);
		return str.toCharArray();
	}

	public char charAtPos(String str,int pos) throws InsufficientLengthException {
		checkObjArgIsNull(str);
		if (findLength(str) > pos) {
			return str.charAt(pos-1);
		} else {
			throw new InsufficientLengthException("String is too small to find  character at position "+pos+", try giving string size greater than "+pos);
		}
	}

	public int countOfChar(String str, char letter) {
		checkObjArgIsNull(str);
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
		checkObjArgIsNull(str);
		return str.lastIndexOf(letter);
	}

	public String printLastNChar(String str, int n) throws InsufficientLengthException,InvalidArgumentException{
		checkObjArgIsNull(str);
		checkNumGreaterThan(n, 1);
		if (findLength(str) > n - 1) {
			return str.substring(findLength(str) - n);
		} else {
			throw new InsufficientLengthException("String is too small to print the last " + n + " characters, try giving string size atleast greater than" + (n - 1));
		}
	}

	public String printFirstNChar(String str, int n) throws InsufficientLengthException,InvalidArgumentException {
		checkObjArgIsNull(str);
		checkNumGreaterThan(n, 1);

		if (findLength(str) > n - 1) {
			return str.substring(0, n);
		} else {
			throw new InsufficientLengthException("String is too small to print the first " + n + " characters, try giving string size atleast greater than " + (n - 1));
		}
	}

	public String replaceFirstNChar(String str, int count, String repStr) throws InsufficientLengthException,InvalidArgumentException {
		checkObjArgIsNull(str);
		checkObjArgIsNull(repStr);
		checkNumGreaterThan(count, 1);
		int length=findLength(str);
		if (length == count) {
			return repStr;
		} else if (length> count) {
			return repStr.concat(str.substring(count));
		} else {
			throw new InsufficientLengthException("String is too small to replace the first " + count + " characters, try giving string size atleast greater than " + (count - 1));
		}
	}

	public boolean checkStartsWith(String str, String starter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(starter);
		return str.startsWith(starter);
	}

	public boolean checkEndsWith(String str, String ender) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(ender);
		return str.endsWith(ender);
	}

	public String convertToUppercase(String str) {
		checkObjArgIsNull(str);
		return str.toUpperCase();
	}

	public String convertToLowercase(String str) {
		checkObjArgIsNull(str);
		return str.toLowerCase();
	}

	public String reverseString(String str) {
		checkObjArgIsNull(str);
		char[] charArr = str.toCharArray();
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

	public String concWithoutGivenChar(String str ,String letter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(letter);
		return str.replace(letter, "");
	}

	public String[] mulStrToStrArr(String str,String delimeter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(delimeter);
		return str.split(delimeter);
	}

	public String mergeStrWithChar(String[] strArr, String merger) {
		checkObjArgIsNull(strArr);
		checkObjArgIsNull(merger);
		return String.join(merger, strArr);
	}

	public boolean checkEqualsCaseSensitive(String str1, String str2) {
		checkObjArgIsNull(str1);
		checkObjArgIsNull(str2);
		return str1.equals(str2);
	}

	public boolean checkEqualsInCaseSensitive(String str1, String str2) {
		checkObjArgIsNull(str1);
		checkObjArgIsNull(str2);
		return str1.equalsIgnoreCase(str2);
	}

	public String trimExtraSpace(String str) {
		checkObjArgIsNull(str);
		return str.trim();
	}

	public void checkObjArgIsNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Argument cannot be null,pass a valid argument");
		}

	}

	public void checkNumGreaterThan(int n,int checker) throws InvalidArgumentException{
		if(n<checker){
			throw new InvalidArgumentException("Integer value should be at least greater than or equal to "+checker+" for this operation.");
		}
	}

}