package com.task;

import com.validator.BoundaryCheckException;
import com.validateargs.ValidateArgs;

public class StringTask {
	ValidateArgs validate = new ValidateArgs();
	public int findLength(String str) {
		validate.checkObjArgIsNull(str);
		return str.length();
	}

	public char[] convertToCharArray(String str) {
		validate.checkObjArgIsNull(str);
		return str.toCharArray();
	}

	public char charAtPos(String str, int pos) throws BoundaryCheckException {
		validate.boundaryCheck(pos, 1, findLength(str));
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
		validate.checkObjArgIsNull(str);
		return str.lastIndexOf(letter);
	}

	public String printLastNChar(String str, int n) throws BoundaryCheckException {
		int length = findLength(str);
		validate.boundaryCheck(n, 1, length);
		return str.substring(length - n);

	}

	public String printFirstNChar(String str, int n) throws BoundaryCheckException {
		validate.boundaryCheck(n, 1, findLength(str));
		return str.substring(0, n);

	}

	public String replaceFirstNChar(String str, int count, String repStr) throws BoundaryCheckException {
		validate.checkObjArgIsNull(repStr);
		validate.boundaryCheck(count, 1, findLength(str));
		return repStr.concat(str.substring(count));
	}

	public boolean checkStartsWith(String str, String starter) {
		validate.checkObjArgIsNull(str);
		validate.checkObjArgIsNull(starter);
		return str.startsWith(starter);
	}

	public boolean checkEndsWith(String str, String ender) {
		validate.checkObjArgIsNull(str);
		validate.checkObjArgIsNull(ender);
		return str.endsWith(ender);
	}

	public String convertToUppercase(String str) {
		validate.checkObjArgIsNull(str);
		return str.toUpperCase();
	}

	public String convertToLowercase(String str) {
		validate.checkObjArgIsNull(str);
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
		validate.checkObjArgIsNull(str);
		validate.checkObjArgIsNull(letter);
		validate.checkObjArgIsNull(replacer);
		return str.replace(letter, replacer);
	}

	public String[] mulStrToStrArr(String str, String delimeter) {
		validate.checkObjArgIsNull(str);
		validate.checkObjArgIsNull(delimeter);
		return str.split(delimeter);
	}

	public String mergeStrWithChar(String[] strArr, String merger) {
		validate.checkObjArgIsNull(strArr);
		validate.checkObjArgIsNull(merger);
		return String.join(merger, strArr);
	}

	public boolean checkEqualsCaseSensitive(String str1, String str2) {
		validate.checkObjArgIsNull(str1);
		validate.checkObjArgIsNull(str2);
		return str1.equals(str2);
	}

	public boolean checkEqualsInCaseSensitive(String str1, String str2) {
		validate.checkObjArgIsNull(str1);
		validate.checkObjArgIsNull(str2);
		return str1.equalsIgnoreCase(str2);
	}

	public String trimExtraSpace(String str) {
		validate.checkObjArgIsNull(str);
		return str.trim();
	}

	

}