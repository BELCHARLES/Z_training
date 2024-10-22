package com.runner;

import com.validator.BoundaryCheckException;
import com.task.StringTask;
import com.inputreader.ReadInput;
import com.validateargs.ValidateArgs;

import java.util.Scanner;
import java.util.Arrays;

public class StringRunner {
	
	ValidateArgs validate = new ValidateArgs();
	ReadInput read = new ReadInput();
	StringTask task = new StringTask();
	Scanner sc = new Scanner(System.in);
	//for storing user inputs
	String str;
	char letter;
	int n;

	public  void printChoiceList() {
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

	public  void handleStringOperations(String strArr[]) {
		StringRunner runner = new StringRunner();
		int choice = sc.nextInt();
		if(choice!=21){
			do {
			switch (choice) {
				case 1:
					runner.handleLength(strArr);
					break;
				case 2:
					runner.handleCharArray();
					break;
				case 3:
					runner.handleCharAtPos();
					break;
				case 4:
					runner.handleCountOfChar();
					break;
				case 5:
					runner.handleGreatestPosition();
					break;
				case 6:
					runner.handlePrintLastNChar();
					break;
				case 7:
					runner.handlePrintFirstNChar();
					break;
				case 8:
					runner.handleReplaceFirstNChar();
					break;
				case 9:
					runner.handleCheckStartsWith();
					break;
				case 10:
					runner.handleCheckEndsWith();
					break;
				case 11:
					runner.handleConvertToUppercase();
					break;
				case 12:
					runner.handleConvertToLowercase();
					break;
				case 13:
					runner.handleReverseString();
					break;
				case 14:
					runner.handleAcceptMultipleString();
					break;
				case 15:
					runner.handleConcWithoutGivenChar();
					break;
				case 16:
					runner.handleMulStrToStrArr();
					break;
				case 17:
					runner.handleMergeStrWithChar();
					break;
				case 18:
					runner.handleCheckEqualsCaseSensitive();
					break;
				case 19:
					runner.handleCheckEqualsInCaseSensitive();
					break;
				case 20:
					runner.handleTrimExtraSpace();
					break;
				default:
					System.out.println("Please enter a valid choice");
					break;

			}
			runner.printChoiceList();
			choice = sc.nextInt();
		} while (choice != 21);
		}
	}

	public  void handleTrimExtraSpace() {
		str = read.getSentenceFromUser();
		System.out.println("The string before trimming : \"" + str + "\"");
		System.out.println("The length of the string before trimming: " + task.findLength(str));
		try {		
			str = task.trimExtraSpace(str);
			System.out.println("The string after trimming: \"" + str + "\"");
			System.out.println("The length of the string after trimming: " + str.length());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleCheckEqualsInCaseSensitive() {
	    System.out.println("Enter the strings to check whether they are equal (case insensitive): ");
		String str1 = read.getStringFromUser();
		String str2 = read.getStringFromUser();
		try {
			System.out.println(task.checkEqualsInCaseSensitive(str1, str2));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleCheckEqualsCaseSensitive() {
		System.out.println("Enter the strings to check whether they are equal (case sensitive): ");
		String str1 = read.getStringFromUser();
		String str2 = read.getStringFromUser();
		try {
			System.out.println(task.checkEqualsCaseSensitive(str1, str2));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleMergeStrWithChar() {
		String strArr[] = read.getMulStrFromUser();
		System.out.println("Enter the string to merge with:");
		String merger = read.getStringFromUser();
		try {
			System.out.println("The string after merging:" + task.mergeStrWithChar(strArr, merger));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleMulStrToStrArr() {
		str = read.getSentenceFromUser();
		System.out.println("Enter the delimeter to split the strings:");
		String str1 = read.getStringFromUser();
		try {
			String strArr[] = task.mulStrToStrArr(str,str1);
			System.out.print("The string array : "+Arrays.toString(strArr));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public  void handleAcceptMultipleString() {
		str = read.getSentenceFromUser();
		System.out.println("You entered: " + str);
	} 

	public  void handleConcWithoutGivenChar() {
        str = read.getSentenceFromUser();
		System.out.println("Enter the string to be removed:");
		String str1 = read.getStringFromUser();
		System.out.println("Enter the string to replce with :");
		String str2 = read.getStringFromUser();		
		try {
			System.out.print("After concatenation of strings without " + str1 + ":"+task.concWithoutGivenChar(str, str1,str2));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleReverseString() {
		str = read.getStringFromUser();
		try {
			System.out.println(str + "->" + task.reverseString(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleConvertToLowercase() {
		str = read.getStringFromUser();
		try {
			System.out.println(str + "->" + task.convertToLowercase(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleConvertToUppercase() {
		str = read.getStringFromUser();
		try {
			System.out.println(str + "->" + task.convertToUppercase(str));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleCheckEndsWith() {
		str = read.getStringFromUser();
		System.out.println("Enter the string to check for:");
		String ender = read.getStringFromUser();
		try {
			boolean ans = task.checkEndsWith(str, ender);
			System.out.println("The String " + str + " ends with " + ender +" : " + ans);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleCheckStartsWith() {
		str = read.getStringFromUser();
		System.out.println("Enter the string to check for:");
		String starter = read.getStringFromUser();
		try {
			boolean ans = task.checkStartsWith(str, starter);
			System.out.println("The String " + str + " starts with " + starter+" : "+ans);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handleReplaceFirstNChar() {
		str = read.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = read.getIntFromUser();
		System.out.println("Enter the string to be replaced with:");
		String repStr = read.getStringFromUser();
		try {
			String outputStr = task.replaceFirstNChar(str, n, repStr);
			System.out.println("On replacing the first " + n + " characters of the string " + str + " with " + repStr
					+ " , it became  " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public  void handlePrintFirstNChar() {
		str = read.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = read.getIntFromUser();
		try {
			String outputStr = task.printFirstNChar(str, n);
			System.out.println("The first " + n + " characters of the string " + str + " is " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	public  void handlePrintLastNChar() {
		str = read.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = read.getIntFromUser();
		try {
			String outputStr = task.printLastNChar(str, n);
			System.out.println("The last " + n + " characters of the string " + str + " is " + outputStr);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public  void handleGreatestPosition() {
		str = read.getStringFromUser();
		char choice = 'y';
		try {
			while (choice == 'y') {
				letter = read.getCharFromUser();
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

	public  void handleCountOfChar() {
		str = read.getStringFromUser();
		char choice = 'y';
		try {
			while (choice == 'y') {
				letter = read.getCharFromUser();
				int count = task.countOfChar(str, letter);
				System.out.println("The  number of occurrences of " + letter + " in the string " + str + " is " + count);
				System.out.print("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
				choice = sc.next().charAt(0);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	//chained exception demo usecase
	public  void handleCharAtPos() {
		str = read.getStringFromUser();
        n=read.getIntFromUser();
		try {
			char posChar = task.charAtPos(str,n);
			System.out.println("The  character at position "+n+" of the string " + str + " is " + posChar);
		} catch (BoundaryCheckException e) {
			System.out.println(e.getMessage());
			System.out.println("\nPrinting Stack trace...");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	public  void handleCharArray() {
		str = read.getStringFromUser();
		try {
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

	public  void handleLength(String strArr[])  {
		try {
			validate.checkObjArgIsNull(strArr);
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

	

	public static void main(String args[]) {
		StringRunner runner = new StringRunner();
		runner.printChoiceList();
		runner.handleStringOperations(args);
	}
}