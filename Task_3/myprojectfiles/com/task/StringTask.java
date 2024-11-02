package com.task;

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

	public char charAtPos(String str, int pos) throws BoundaryCheckException {
		ValidateArgs.boundaryCheck(pos, 1, findLength(str));
		return str.charAt(pos - 1);
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

	public String printLastNChar(String str, int n) throws BoundaryCheckException {
		int length = findLength(str);
		ValidateArgs.boundaryCheck(n, 1, length);
		return str.substring(length - n);

	}

	public String printFirstNChar(String str, int n) throws BoundaryCheckException {
		ValidateArgs.boundaryCheck(n, 1, findLength(str));
		return str.substring(0, n);

	}

	public String replaceFirstNChar(String str, int count, String repStr) throws BoundaryCheckException {
		ValidateArgs.checkObjArgIsNull(repStr);
		ValidateArgs.boundaryCheck(count, 1, findLength(str));
		return repStr.concat(str.substring(count));
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

	public String convertToUppercase(String str) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.toUpperCase();
	}

	public String convertToLowercase(String str) {
		ValidateArgs.checkObjArgIsNull(str);
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

	public String concWithoutGivenChar(String str, String letter,String replacer) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(letter);
		ValidateArgs.checkObjArgIsNull(replacer);
		return str.replace(letter, replacer);
	}

	public String[] mulStrToStrArr(String str, String delimeter) {
		ValidateArgs.checkObjArgIsNull(str);
		ValidateArgs.checkObjArgIsNull(delimeter);
		return str.split(delimeter);
	}

	public String mergeStrWithChar(String[] strArr, String merger) {
		ValidateArgs.checkObjArgIsNull(strArr);
		ValidateArgs.checkObjArgIsNull(merger);
		return String.join(merger, strArr);
	}

	public boolean checkEqualsCaseSensitive(String str1, String str2) {
		ValidateArgs.checkObjArgIsNull(str1);
		ValidateArgs.checkObjArgIsNull(str2);
		return str1.equals(str2);
	}

	public boolean checkEqualsInCaseSensitive(String str1, String str2) {
		ValidateArgs.checkObjArgIsNull(str1);
		ValidateArgs.checkObjArgIsNull(str2);
		return str1.equalsIgnoreCase(str2);
	}

	public String trimExtraSpace(String str) {
		ValidateArgs.checkObjArgIsNull(str);
		return str.trim();
	}

	

}