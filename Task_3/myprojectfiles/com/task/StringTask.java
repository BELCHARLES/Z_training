package com.task;

public class StringTask{
	public int checkCmdArgs(String str[]){
		if(str.length > 0){
			return findLength(str[0]);
		}
		else{
			return -1;
		}	
	}

	public int findLength(String str){
		return str.length();
	}

	public char[] convertToCharArray(String str){
		return str.toCharArray();
	}

	public char penultimate(String str){
		if(str.length()>2){
			return str.charAt(str.length()-2);
		}
		else{	
			return '\0';
		}
	}

	public int  countOfChar(String str,char letter){
		int count = 0;
		for (int i=0; i<str.length();i++){
			if(str.charAt(i)==letter){
				count++;
			}
		}
		return count;
	}

	public int greatestPosOfChar(String str,char letter){
		return str.lastIndexOf(letter);
	}

	public String printLastFive (String str){
		if(str.length() > 4){
			return str.substring(str.length()-5);
		}
		else{
			return null;
		}
	}

	public String printFirstThree(String str){
		if(str.length() > 2){
			return str.substring(0,3);
		}
		else{
			return null;
		}
	}

	public String replaceFirstThree(String str){
		if(str.length() == 3){
			return "XYZ";
		}
		else if (str.length() > 3){
			return "XYZ".concat(str.substring(3));
		}
		else{
			return null;
		}
	}

	public boolean checkStartsWith(String str , String starter){
		if(str.startsWith(starter)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean checkEndsWith(String str , String ender){
		if(str.endsWith(ender)){
			return true;
		}
		else{
			return false;
		}
	}

	public String convertToUppercase(String str){
		return str.toUpperCase();
	}

	public String convertToLowercase(String str){
		return str.toLowerCase();
	}

	public String reverseString(String str){
		String output="";
		int start = str.length()-1;
		for(int i=start;i>=0;i--){
			output = output + str.charAt(i);
		}
		return output;
	}

	public String concWithoutSpace(String str){
		String strArr [] = str.split(" ");
		String output="";
		for(String word :strArr){
			output=output+word;
		}
		return output;
	}

	public String [] mulStrToStrArr(String str){
		return str.split(" ");
	}

	public String mergeStrWithHyphen(String []strArr){
		String output="";
		int i;
		for(i=0;i<(strArr.length-1);i++){
			output=output+strArr[i]+"-";
		}
		output+=strArr[i];
		return output;
	}

	public boolean checkEqualsCaseSensitive(String str1,String str2){
		return str1.equals(str2);
	}

	public boolean checkEqualsInCaseSensitive(String str1,String str2){
		return str1.equalsIgnoreCase(str2);
	}

	public String trimExtraSpace(String str){
		return str.trim();
	}

}