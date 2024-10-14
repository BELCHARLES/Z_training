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

	public char charAtPos(String str, int pos) throws BoundaryCheckException {
		boundaryCheck(pos, 1, findLength(str));
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
		checkObjArgIsNull(str);
		return str.lastIndexOf(letter);
	}

	public String printLastNChar(String str, int n) throws BoundaryCheckException {
		int length = findLength(str);
		boundaryCheck(n, 1, length);
		return str.substring(length - n);

	}

	public String printFirstNChar(String str, int n) throws BoundaryCheckException {
		boundaryCheck(n, 1, findLength(str));
		return str.substring(0, n);

	}

	public String replaceFirstNChar(String str, int count, String repStr) throws BoundaryCheckException {
		checkObjArgIsNull(repStr);
		boundaryCheck(count, 1, findLength(str));
		return repStr.concat(str.substring(count));
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

	public String concWithoutGivenChar(String str, String letter) {
		checkObjArgIsNull(str);
		checkObjArgIsNull(letter);
		return str.replace(letter, "");
	}

	public String[] mulStrToStrArr(String str, String delimeter) {
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

	public void boundaryCheck(int n, int min, int max) throws BoundaryCheckException {
		if (n < min) {
			throw new BoundaryCheckException(
					"Integer value should be at least greater than or equal to " + min + " for this operation.");
		} else if (n > max) {
			throw new BoundaryCheckException(
					"Integer value should be at most less than or equal to" + max + "for this operation");
		}
	}

}