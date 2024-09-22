package  com.runner;

import com.task.*;
import java.util.*;

public class Runner{

	static Task task = new Task();
	static Scanner sc = new Scanner(System.in);
	static String str;
	static char letter;
	

	public static void printChoiceList(){
		System.out.println("S.no Functions");
		System.out.println("1.  Find the length of a String");
		System.out.println("2.  Convert string  into character Array");
		System.out.println("3.  Find penultimate character");
		System.out.println("4.  Find the number of occurrences of a given letter/character");
		System.out.println("5.  Find the greatest position of the given letter/character.");
		System.out.println("6.  Print the last 5 characters of a given String.");
		System.out.println("7.  Print the first 3 characters of a given String");
		System.out.println("8.  Replace the first 3 characters of a String with \"XYZ\" ");
		System.out.println("9.  Check whether a String starts with \"ent\" ");
		System.out.println("10.  Check whether a String ends with \"le\" ");
		System.out.println("11.  Convert all lowercase string to uppercase string");
		System.out.println("12.  Convert all uppercase string to lowercase string");
		System.out.println("13.  Reverse a String");
		System.out.println("14.  Accept a line with multiple Strings");
		System.out.println("15.  Concatenate multiple strings without space");
		System.out.println("16.  Multiple strings to string array");
		System.out.println("17.  Merge multipe strings with \"-\" in between");
		System.out.println("18.  Check equality of 2 strings - Case sensitive");
		System.out.println("19.  Check equality of 2 strings - Case insensitive");
		System.out.println("20.  String with a space at the end & beginning or both and output the proper String with no space either at the beginning or end");
		System.out.println("21. Exit");
		System.out.println("Please enter the corresponding serial number to perform the requied function:");
	}

	public static void inputOutputHandler(String strArr[]){
		int choice=sc.nextInt();
		
		do{
			switch(choice){
				case 1:
					lengthHandler(strArr);
					break;	
				case 2:
					charArrayHandler();
					break;
				case 3:
					penultimateHandler();
					break;
				case 4:
					countOfCharHandler();
					break;
				case 5:
					greatestPositionHandler();
					break;
				case 6:
					printLastFiveHandler();
					break;
				case 7:
					printFirstThreeHandler();
					break;
				case 8:
					replaceFirstThreeHandler();
					break;
				case 9:
					checkStartsWithHandler();
					break;
				case 10:
					checkEndsWithHandler();
					break;
				case 11:
					convertToUppercaseHandler();
					break;
				case 12:
					convertToLowercaseHandler();
					break;
				case 13:
					reverseStringHandler();
					break;
				case 14:
					acceptMultipleStringHandler();
					break;
				case 15:
					concWithoutSpaceHandler();
					break;
				case 16:
					mulStrToStrArrHandler();
					break;
				case 17:
					mergeStrWithHyphenHandler();
					break;
				case 18:
					checkEqualsCaseSensitiveHandler();
					break;
				case 19:
					checkEqualsInCaseSensitiveHandler();
					break;
				case 20:
					trimExtraSpaceHandler();
					break;

			}
			printChoiceList();
			choice = sc.nextInt();
		}while(choice!=21);
	}

	public static void trimExtraSpaceHandler(){
		str = getSentenceFromUser();
		System.out.println("The string before trimming : \""+str+"\"");
		System.out.println("The length of the string before trimming: "+str.length());
		str = task.trimExtraSpace(str);
		System.out.println("The string after trimming: \""+str+"\"");
		System.out.println("The length of the string after trimming: "+str.length());
	}

	public static void checkEqualsInCaseSensitiveHandler(){
		System.out.println("Enter the strings to check whether they are equal (case insensitive): ");
		String str1 = getStringFromUser();
		String str2 = getStringFromUser();
		System.out.println(task.checkEqualsInCaseSensitive(str1,str2));
	}


	public static void checkEqualsCaseSensitiveHandler(){
		System.out.println("Enter the strings to check whether they are equal (case sensitive): ");
		String str1 = getStringFromUser();
		String str2 = getStringFromUser();
		System.out.println(task.checkEqualsCaseSensitive(str1,str2));
	}

	public static void mergeStrWithHyphenHandler(){
		String strArr[] = getMulStrFromUser();
		System.out.println("The string after merging with hypen:"+task.mergeStrWithHyphen(strArr));
	}

	public static void mulStrToStrArrHandler(){
		int i;
		str=getSentenceFromUser();
		String strArr[]=task.mulStrToStrArr(str);
		System.out.print("The string array : {");
		for( i=0;i<strArr.length-1;i++){
			System.out.print("\""+strArr[i]+"\",");
		}
		System.out.println("\""+strArr[i]+"\"}");
	}


	public static void concWithoutSpaceHandler(){
		str=getSentenceFromUser();
		System.out.println("After concatenation of strings without space: "+task.concWithoutSpace(str));
	}

	public static void acceptMultipleStringHandler(){
		str=getSentenceFromUser();
		System.out.println("You entered: "+str);
	}

	public static void reverseStringHandler(){
		str = getStringFromUser();
		System.out.println(str+"->"+task.reverseString(str));
	}

	public static void convertToLowercaseHandler(){
		str = getStringFromUser();
		System.out.println(str+"->"+task.convertToLowercase(str));
	}

	public static void convertToUppercaseHandler(){
		str = getStringFromUser();
		System.out.println(str+"->"+task.convertToUppercase(str));
	}

	public static void checkEndsWithHandler(){
		str = getStringFromUser();
		boolean ans = task.checkEndsWith(str,"le");
		if(ans == true ){
			System.out.println("The String "+str+" ends with \"le\"");
		}
		else{
			System.out.println("The String "+str+" does not end with \"le\"");
		}
	}

	public static void checkStartsWithHandler(){
		str = getStringFromUser();
		boolean ans = task.checkStartsWith(str,"ent");
		if(ans == true ){
			System.out.println("The String "+str+" starts with \"ent\"");
		}
		else{
			System.out.println("The String "+str+" does not start with \"ent\"");
		}
	}

	public static void replaceFirstThreeHandler(){
		str = getStringFromUser();
		String outputStr = task.replaceFirstThree(str);
		if(outputStr != null ){
			System.out.println("On replacing the first three characters of the string "+str+" with XYZ, it became  "+outputStr);
		}
		else{
			System.out.println("String is too small to replace the first three characters, try giving string size atleast greater than 2");
		}
	}


	public static void printFirstThreeHandler(){
		str = getStringFromUser();
		String outputStr = task.printFirstThree(str);
		if(outputStr != null ){
			System.out.println("The first 3 characters of the string "+str+" are "+outputStr);
		}
		else{
			System.out.println("String is too small to print the first three characters, try giving string size atleast greater than 2");
		}
	}

	public static void printLastFiveHandler(){
		str = getStringFromUser();
		String outputStr = task.printLastFive(str);
		if(outputStr != null ){
			System.out.println("The last 5 characters of the string "+str+" are "+outputStr);
		}
		else{
			System.out.println("String is too small to print the last five characters, try giving string size atleast greater than 4");
		}
	}

	public static void greatestPositionHandler(){
		str =  getStringFromUser();
		char choice = 'y';
		while(choice == 'y'){
			letter = getCharFromUser();
			int index = task.greatestPosOfChar(str,letter);
			if(index!=-1){
				System.out.println("The greatest position of  "+letter+" in the string "+str+" is "+(index+1));
			}
			else{
				System.out.println("Character "+letter+" is not found in the string "+str );
			}
			System.out.println("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
			choice = sc.next().charAt(0);
		}
		
	}

	public static void countOfCharHandler(){
		str =  getStringFromUser();
		char choice = 'y';
		System.out.println(choice);
		while(choice == 'y'){
			letter = getCharFromUser();
			int count = task.countOfChar(str,letter);
			System.out.println("The  number of occurrences of "+letter+" in the string "+str+" is "+count);						    			         	System.out.println("Do you want to check for another letter/character (Enter 'y' for yes and 'n' for no) :");
			choice = sc.next().charAt(0);
		}

	}

	public static void penultimateHandler(){
		str = getStringFromUser();
		char penultimateChar = task.penultimate(str);
		if(penultimateChar != '\0'){
			System.out.println("The penultimate character of the string "+str+"is "+penultimateChar);
		}
		else{
			System.out.println("String is too small to find penultimate character, try giving string size greater than 3");
		}
	}

	public static void charArrayHandler(){
		str = getStringFromUser();
		char[] charArray = task.convertToCharArray(str);
		System.out.println(str+" on converting to character array... ");
		for(char c :charArray){
			System.out.print(c+" ");
		}
		System.out.println();
	}

	public static void lengthHandler(String strArr[]){
		int length=task.checkCmdArgs(strArr);
		if(length!=-1){
			System.out.println("The length of the string "+strArr[0]+" = "+length);
		}
		else{
			System.out.println("No string provided as command line argument ,try running the file again with the arguments");
		}
	}
	
	public static String getStringFromUser(){
		System.out.print("Enter the string :");
		return sc.next();
	}

	public static String getSentenceFromUser(){
		System.out.print("Enter the string :");
		sc.nextLine();
		return sc.nextLine();
	}

	public static String[] getMulStrFromUser(){
		System.out.print("Enter the number of strings :");
		int count =sc.nextInt();
		String strArr[]=new String[count];
		for(int i=0;i<count;i++){
			System.out.print("Enter string "+(i+1)+":");
			strArr[i]=sc.next();
		}
		return strArr;
	}

	public static char getCharFromUser(){
		System.out.println("Enter the character :");
		return sc.next().charAt(0);
	}

	public static void main (String args[]){
		printChoiceList();
		inputOutputHandler(args);
	}
}