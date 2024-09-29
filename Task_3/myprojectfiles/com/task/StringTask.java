package com.task;

import java.util.ArrayList;

import com.exception.*;

public class StringTask {
	public int checkCmdArgs(String str[]) throws InsufficientLengthException {
		if (str.length > 0) {
			return findLength(str[0]);
		} else {
			throw new InsufficientLengthException("No string provided as command line argument ,try running the file again with the arguments");
		}
	}

	public int findLength(String str) {
		checkObjArgIsNull(str);
		return str.length();
	}

	public char[] convertToCharArray(String str) {
		checkObjArgIsNull(str);
		return str.toCharArray();
	}

	public char penultimate(String str) throws InsufficientLengthException {
		checkObjArgIsNull(str);
		if (str.length() > 2) {
			return str.charAt(str.length() - 2);
		} else {
			throw new InsufficientLengthException("String is too small to find penultimate character, try giving string size greater than 2");
		}
	}

	public int countOfChar(String str, Character letter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(letter);
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == letter) {
				count++;
			}
		}
		return count;
	}

	public int greatestPosOfChar(String str, Character letter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(letter);
		return str.lastIndexOf(letter);
	}

	public String printLastNChar(String str, Integer n) throws InsufficientLengthException,InvalidArgumentException{
		checkObjArgIsNull(str);
		checkObjArgIsNull(n);
		checkNumGreaterThan(n, 1);
		if (str.length() > n - 1) {
			return str.substring(str.length() - n);
		} else {
			throw new InsufficientLengthException("String is too small to print the last " + n + " characters, try giving string size atleast greater than" + (n - 1));
		}
	}

	public String printFirstNChar(String str, Integer n) throws InsufficientLengthException,InvalidArgumentException {
		checkObjArgIsNull(str);
		checkObjArgIsNull(n);
		checkNumGreaterThan(n, 1);

		if (str.length() > n - 1) {
			return str.substring(0, n);
		} else {
			throw new InsufficientLengthException("String is too small to print the first " + n + " characters, try giving string size atleast greater than " + (n - 1));
		}
	}

	public String replaceFirstNChar(String str, Integer count, String repStr) throws InsufficientLengthException,InvalidArgumentException {
		checkObjArgIsNull(str);
		checkObjArgIsNull(count);
		checkObjArgIsNull(repStr);
		checkNumGreaterThan(count, 1);
		if (str.length() == count) {
			return repStr;
		} else if (str.length() > count) {
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
		int right = str.length() - 1;
		while (left < right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] = temp;
			left++;
			right--;
		}
		return new String(charArr);
	}

	public ArrayList<Character> concWithoutGivenChar(String str ,Character letter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(letter);
		char[] charArr = str.toCharArray();
		ArrayList<Character> outputStr = new ArrayList<>();
		for (char c : charArr) {
			if (c != letter) {
				outputStr.add(c);
			}
		}
		return outputStr;
	}

	public String[] mulStrToStrArr(String str) {
		checkObjArgIsNull(str);
		return str.split(" ");
	}

	public String mergeStrWithChar(String[] strArr, Character merger) {
		checkObjArgIsNull(strArr);
		checkObjArgIsNull(merger);
		String outputStr = "";
		int i;
		for (i = 0; i < (strArr.length - 1); i++) {
			outputStr = outputStr + strArr[i] + merger;
		}
		outputStr += strArr[i];
		return outputStr;
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

	public void checkNumGreaterThan(Integer n,Integer checker) throws InvalidArgumentException{
		if(n<checker){
			throw new InvalidArgumentException("Integer value should be at least greater than or equal to "+checker+" for this operation.");
		}
	}

}