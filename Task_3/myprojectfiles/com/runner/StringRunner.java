package com.runner;

import com.exception.*;
import com.task.*;
import java.util.*;

public class StringRunner {

	static StringTask task = new StringTask();
	static Scanner sc = new Scanner(System.in);
	static String str;
	static char letter;
	static int n;

	public static void printChoiceList() {
		System.out.println("\nS.no Functions");
		System.out.println("1.   Find the length of a String");
		System.out.println("2.   Convert string  into character Array");
		System.out.println("3.   Find the character at given position");
		System.out.println("4.   Find the number of occurrences of a given letter/character");
		System.out.println("5.   Find the greatest position of the given letter/character.");
		System.out.println("6.   Print the last 'n' characters of a given String.");
		System.out.println("7.   Print the first 'n' characters of a given String");
		System.out.println("8.   Replace the first 'n' characters of a String with the given string");
		System.out.println("9.   Check whether a String starts with the given string ");
		System.out.println("10.  Check whether a String ends with the given string");
		System.out.println("11.  Convert all lowercase string to uppercase string");
		System.out.println("12.  Convert all uppercase string to lowercase string");
		System.out.println("13.  Reverse a String");
		System.out.println("14.  Accept a line with multiple Strings");
		System.out.println("15.  Concatenate multiple strings without given character");
		System.out.println("16.  Multiple strings to string array");
		System.out.println("17.  Merge multipe strings with the given character  in between");
		System.out.println("18.  Check equality of 2 strings - Case sensitive");
		System.out.println("19.  Check equality of 2 strings - Case insensitive");
		System.out.println("20.  Trim spaces");
		System.out.println("21.  Exit");
		System.out.print("Please enter the corresponding serial number to perform the requied function:");
	}

	public static void handleStringOperations(String strArr[]) {
		int choice = sc.nextInt();

		do {
			switch (choice) {
				case 1:
					handleLength(strArr);
					break;
				case 2:
					handleCharArray();
					break;
				case 3:
					handleCharAtPos();
					break;
				case 4:
					handleCountOfChar();
					break;
				case 5:
					handleGreatestPosition();
					break;
				case 6:
					handlePrintLastNChar();
					break;
				case 7:
					handlePrintFirstNChar();
					break;
				case 8:
					handleReplaceFirstNChar();
					break;
				case 9:
					handleCheckStartsWith();
					break;
				case 10:
					handleCheckEndsWith();
					break;
				case 11:
					handleConvertToUppercase();
					break;
				case 12:
					handleConvertToLowercase();
					break;
				case 13:
					handleReverseString();
					break;
				case 14:
					handleAcceptMultipleString();
					break;
				case 15:
					handleConcWithoutGivenChar();
					break;
				case 16:
					handleMulStrToStrArr();
					break;
				case 17:
					handleMergeStrWithChar();
					break;
				case 18:
					handleCheckEqualsCaseSensitive();
					break;
				case 19:
					handleCheckEqualsInCaseSensitive();
					break;
				case 20:
					handleTrimExtraSpace();
					break;

			}
			printChoiceList();
			choice = sc.nextInt();
		} while (choice != 21);
	}

	public static void handleTrimExtraSpace() {
		try {
			str = getSentenceFromUser();

			String str1 = task.trimExtraSpace(str);
			System.out.println("The string before trimming : \"" + str + "\"");
			System.out.println("The length of the string before trimming: " + str.length());

			System.out.println("The string after trimming: \"" + str1 + "\"");
			System.out.println("The length of the string after trimming: " + str1.length());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCheckEqualsInCaseSensitive() {
		try {
			System.out.println("Enter the strings to check whether they are equal (case insensitive): ");
			String str1 = getStringFromUser();
			String str2 = getStringFromUser();
			System.out.println(task.checkEqualsInCaseSensitive(str1, str2));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCheckEqualsCaseSensitive() {
		try {
			System.out.println("Enter the strings to check whether they are equal (case sensitive): ");
			String str1 = getStringFromUser();
			String str2 = getStringFromUser();
			System.out.println(task.checkEqualsCaseSensitive(str1, str2));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleMergeStrWithChar() {
		try {
			String strArr[] = getMulStrFromUser();
			System.out.println("Enter the string to merge with:");
			String merger = getStringFromUser();
			System.out.println("The string after merging:" + task.mergeStrWithChar(strArr, merger));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleMulStrToStrArr() {
		try {
			int i;
			str = getSentenceFromUser();
			System.out.println("Enter the delimeter to split the strings:");
			String str1 = getStringFromUser();
			String strArr[] = task.mulStrToStrArr(str,str1);
			System.out.print("The string array : {");
			for (i = 0; i < strArr.length - 1; i++) {
				System.out.print("\"" + strArr[i] + "\",");
			}
			System.out.println("\"" + strArr[i] + "\"}");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleConcWithoutGivenChar() {
		try {
			str = getSentenceFromUser();
			System.out.println("Enter the string to be left after concatenation:");
			String str1 = getStringFromUser();
			System.out.print("After concatenation of strings without " + str1 + ":"+task.concWithoutGivenChar(str, str1));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleAcceptMultipleString() {
		try {
			str = getSentenceFromUser();
			System.out.println("You entered: " + str);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleReverseString() {
		try {
			str = getStringFromUser();
			System.out.println(str + "->" + task.reverseString(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleConvertToLowercase() {
		try {
			str = getStringFromUser();
			System.out.println(str + "->" + task.convertToLowercase(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleConvertToUppercase() {
		try {
			str = getStringFromUser();
			System.out.println(str + "->" + task.convertToUppercase(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCheckEndsWith() {
		try {
			str = getStringFromUser();
			System.out.println("Enter the string to check for:");
			String ender = getStringFromUser();
			boolean ans = task.checkEndsWith(str, ender);
			if (ans == true) {
				System.out.println("The String " + str + " ends with " + ender);
			} else {
				System.out.println("The String " + str + " does not end with " + ender);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCheckStartsWith() {
		try {
			str = getStringFromUser();
			System.out.println("Enter the string to check for:");
			String starter = getStringFromUser();
			boolean ans = task.checkStartsWith(str, starter);
			if (ans == true) {
				System.out.println("The String " + str + " starts with " + starter);
			} else {
				System.out.println("The String " + str + " does not start with " + starter);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleReplaceFirstNChar() {
		try {
			str = getStringFromUser();
			System.out.println("Enter the number of characters");
			n = getIntFromUser();
			System.out.println("Enter the string to be replaced with:");
			String repStr = getStringFromUser();
			String outputStr = task.replaceFirstNChar(str, n, repStr);
			System.out.println("On replacing the first " + n + " characters of the string " + str + " with " + repStr
					+ " , it became  " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void handlePrintFirstNChar() {
		try {
			str = getStringFromUser();
			System.out.println("Enter the number of characters");
			n = getIntFromUser();
			String outputStr = task.printFirstNChar(str, n);
			System.out.println("The first " + n + " characters of the string " + str + " is " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handlePrintLastNChar() {
		try {
			str = getStringFromUser();
			System.out.println("Enter the number of characters");
			n = getIntFromUser();
			String outputStr = task.printLastNChar(str, n);
			System.out.println("The last " + n + " characters of the string " + str + " is " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void handleGreatestPosition() {
		try {
			str = getStringFromUser();
			char choice = 'y';
			while (choice == 'y') {
				letter = getCharFromUser();
				int index = task.greatestPosOfChar(str, letter);
				if (index != -1) {
					System.out.println("The greatest position of  " + letter + " in the string " + str + " is " + (index + 1));
				} else {
					System.out.println("Character " + letter + " is not found in the string " + str);
				}
				System.out.print("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
				choice = sc.next().charAt(0);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCountOfChar() {
		try {
			str = getStringFromUser();
			char choice = 'y';
			while (choice == 'y') {
				letter = getCharFromUser();
				int count = task.countOfChar(str, letter);
				System.out.println("The  number of occurrences of " + letter + " in the string " + str + " is " + count);
				System.out.print("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
				choice = sc.next().charAt(0);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCharAtPos() {
		try {
			str = getStringFromUser();
            n=getIntFromUser();
			char posChar = task.charAtPos(str,n);
			System.out.println("The  character at position "+n+" of the string " + str + " is " + posChar);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleCharArray() {
		try {
			str = getStringFromUser();
			char[] charArray = task.convertToCharArray(str);
			System.out.println(str + " on converting to character array... ");
			for (char c : charArray) {
				System.out.print(c + " ");
			}
			System.out.println();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void handleLength(String strArr[])  {
		try {
			task.checkObjArgIsNull(strArr);
			if (strArr.length > 0) {
				int length=task.findLength(strArr[0]);
				System.out.println("The length of the string " + strArr[0] + " = " + length);
			} else {
				System.out.println("No string provided as command line argument ,try running the file again with the arguments");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getStringFromUser() {
		System.out.print("Enter the string :");
		return sc.next();
	}

	public static String getSentenceFromUser() {
		System.out.print("Enter the string :");
		sc.nextLine();
		return sc.nextLine();
	}

	public static String[] getMulStrFromUser() {
		System.out.print("Enter the number of strings :");
		int count = sc.nextInt();
		String strArr[] = new String[count];
		for (int i = 0; i < count; i++) {
			System.out.print("Enter string " + (i + 1) + ":");
			strArr[i] = sc.next();
		}
		return strArr;
	}

	public static char getCharFromUser() {
		System.out.print("Enter the character :");
		return sc.next().charAt(0);
	}

	public static int getIntFromUser() {
		System.out.print("Enter the number :");
		return sc.nextInt();
	}

	public static void main(String args[]) {
		printChoiceList();
		handleStringOperations(args);
	}
}