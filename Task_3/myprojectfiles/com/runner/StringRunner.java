package com.runner;

import com.validator.BoundaryCheckException;
import com.task.StringTask;
import com.inputreader.ReadInput;
import com.validateargs.ValidateArgs;

import java.util.Scanner;
import java.util.Arrays;

public class StringRunner {

	StringTask task = new StringTask();
	Scanner sc = new Scanner(System.in);
	// for storing user inputs
	String str;
	char letter;
	int n;

	public void printChoiceList() {
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
		
		//if choice = 21 => exit
		if(choice == 21){
			sc.close();
			ReadInput.closeScanner();
			return;
		}
		
		do {
			try{
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
		    }
			catch (IllegalArgumentException | BoundaryCheckException e){
			System.out.println(e.getMessage());
			System.out.println("Printing Stack Trace...");
			e.printStackTrace();
		}
		runner.printChoiceList();
		choice = sc.nextInt();
		} while (choice != 21);
		sc.close();
		ReadInput.closeScanner();
	}

	public void handleTrimExtraSpace() {
		str = ReadInput.getSentenceFromUser();
		System.out.println("The string before trimming : \"" + str + "\"");
		System.out.println("The length of the string before trimming: " + task.findLength(str));
		str = task.trimExtraSpace(str);
		System.out.println("The string after trimming: \"" + str + "\"");
		System.out.println("The length of the string after trimming: " + str.length());
	}

	public void handleCheckEqualsInCaseSensitive() {
		System.out.println("Enter the strings to check whether they are equal (case insensitive): ");
		String str1 = ReadInput.getStringFromUser();
		String str2 = ReadInput.getStringFromUser();
		System.out.println(task.checkEqualsInCaseSensitive(str1, str2));
	}

	public void handleCheckEqualsCaseSensitive() {
		System.out.println("Enter the strings to check whether they are equal (case sensitive): ");
		String str1 = ReadInput.getStringFromUser();
		String str2 = ReadInput.getStringFromUser();
		System.out.println(task.checkEqualsCaseSensitive(str1, str2));
	}

	public void handleMergeStrWithChar() {
		String strArr[] = ReadInput.getMulStrFromUser();
		System.out.println("Enter the string to merge with:");
		String merger = ReadInput.getStringFromUser();
		System.out.println("The string after merging:" + task.mergeStrWithChar(strArr, merger));
	}

	public void handleMulStrToStrArr() {
		str = ReadInput.getSentenceFromUser();
		System.out.println("Enter the delimeter to split the strings:");
		String str1 = ReadInput.getStringFromUser();
		String strArr[] = task.mulStrToStrArr(str, str1);
		System.out.print("The string array : " + Arrays.toString(strArr));
	}

	public void handleAcceptMultipleString() {
		str = ReadInput.getSentenceFromUser();
		System.out.println("You entered: " + str);
	}

	public void handleConcWithoutGivenChar() {
		str = ReadInput.getSentenceFromUser();
		System.out.println("Enter the string to be removed:");
		String str1 = ReadInput.getStringFromUser();
		System.out.println("Enter the string to replce with :");
		String str2 = ReadInput.getStringFromUser();
		System.out.print(
				"After concatenation of strings without " + str1 + ":" + task.concWithoutGivenChar(str, str1, str2));
	}

	public void handleReverseString() {
		str = ReadInput.getStringFromUser();
		System.out.println(str + "->" + task.reverseString(str));
	}

	public void handleConvertToLowercase() {
		str = ReadInput.getStringFromUser();
		System.out.println(str + "->" + task.convertToLowercase(str));
	}

	public void handleConvertToUppercase() {
		str = ReadInput.getStringFromUser();
		System.out.println(str + "->" + task.convertToUppercase(str));
	}

	public void handleCheckEndsWith() {
		str = ReadInput.getStringFromUser();
		System.out.println("Enter the string to check for:");
		String ender = ReadInput.getStringFromUser();
		boolean ans = task.checkEndsWith(str, ender);
		System.out.println("The String " + str + " ends with " + ender + " : " + ans);
	}

	public void handleCheckStartsWith() {
		str = ReadInput.getStringFromUser();
		System.out.println("Enter the string to check for:");
		String starter = ReadInput.getStringFromUser();
		boolean ans = task.checkStartsWith(str, starter);
		System.out.println("The String " + str + " starts with " + starter + " : " + ans);
	}

	public void handleReplaceFirstNChar() throws BoundaryCheckException {
		str = ReadInput.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = ReadInput.getIntFromUser();
		System.out.println("Enter the string to be replaced with:");
		String repStr = ReadInput.getStringFromUser();
		String outputStr = task.replaceFirstNChar(str, n, repStr);
		System.out.println("On replacing the first " + n + " characters of the string " + str + " with " + repStr
				+ " , it became  " + outputStr);
	}

	public void handlePrintFirstNChar() throws BoundaryCheckException {
		str = ReadInput.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = ReadInput.getIntFromUser();
		String outputStr = task.printFirstNChar(str, n);
		System.out.println("The first " + n + " characters of the string " + str + " is " + outputStr);
	}

	public void handlePrintLastNChar() throws BoundaryCheckException {
		str = ReadInput.getStringFromUser();
		System.out.println("Enter the number of characters");
		n = ReadInput.getIntFromUser();
		String outputStr = task.printLastNChar(str, n);
		System.out.println("The last " + n + " characters of the string " + str + " is " + outputStr);
	}

	public void handleGreatestPosition() {
		str = ReadInput.getStringFromUser();
		char choice = 'y';
		while (choice == 'y') {
			letter = ReadInput.getCharFromUser();
			int index = task.greatestPosOfChar(str, letter);
			if (index != -1) {
				System.out.println(
						"The greatest position of  " + letter + " in the string " + str + " is " + (index + 1));
			} else {
				System.out.println("Character " + letter + " is not found in the string " + str);
			}
			System.out.print("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
			choice = sc.next().charAt(0);
		}
	}

	public void handleCountOfChar() {
		str = ReadInput.getStringFromUser();
		char choice = 'y';
		while (choice == 'y') {
			letter = ReadInput.getCharFromUser();
			int count = task.countOfChar(str, letter);
			System.out.println("The  number of occurrences of " + letter + " in the string " + str + " is " + count);
			System.out.print("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
			choice = sc.next().charAt(0);
		}
	}

	public void handleCharAtPos() throws BoundaryCheckException {
		str = ReadInput.getStringFromUser();
		n = ReadInput.getIntFromUser();
		char posChar = task.charAtPos(str, n);
		System.out.println("The character at position " + n + " of the string " + str + " is " + posChar);
	}

	public void handleCharArray() {
		str = ReadInput.getStringFromUser();
		char[] charArray = task.convertToCharArray(str);
		System.out.println(str + " on converting to character array... ");
		for (char c : charArray) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	public void handleLength(String strArr[]) {
		ValidateArgs.checkObjArgIsNull(strArr);
		if (strArr.length > 0) {
			int length = task.findLength(strArr[0]);
			System.out.println("The length of the string " + strArr[0] + " = " + length);
		} else {
			System.out.println(
					"No string provided as command line argument ,try running the file again with the arguments");
		}
	}

	public static void main(String args[]) {
		StringRunner runner = new StringRunner();
		runner.printChoiceList();
		runner.handleStringOperations(args);
	}
}