package com.inputreader;

import java.util.Scanner;

public class ReadInput{
	Scanner sc =new Scanner(System.in);
    public  String getStringFromUser() {
		System.out.print("Enter the string :");
		return sc.next();
	}

	public  String getSentenceFromUser() {
		System.out.print("Enter the string :");
		sc.nextLine();
		return sc.nextLine();
	}

	public  String[] getMulStrFromUser() {
		System.out.print("Enter the number of strings :");
		int count = sc.nextInt();
		String strArr[] = new String[count];
		for (int i = 0; i < count; i++) {
			System.out.print("Enter string " + (i + 1) + ":");
			strArr[i] = sc.next();
		}
		return strArr;
	}

	public  char getCharFromUser() {
		System.out.print("Enter the character :");
		return sc.next().charAt(0);
	}

	public  int getIntFromUser() {
		System.out.print("Enter the number :");
		return sc.nextInt();
	}
}