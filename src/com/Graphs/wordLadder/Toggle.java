package com.Graphs.wordLadder;

import java.util.Scanner;

public class Toggle {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String result=getLength(s);
		System.out.println("Length: "+result);
	}
	
	public static String getLength(String s)
	{
		String value="";int j=0;
		for(int i=s.length()-1;i>=0;i--,j++)
		{
			value=s.charAt(i)+value;
			if(Integer.parseInt(value)==(s.length()-j-1))
				break;
		}
		return s.substring(0, s.length()-j-1);
	}

}
