package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		
		int count = 0;
		LinkedList<String> name = new LinkedList<String>();
		Scanner scan = new Scanner(System.in);
		
		while(count<3) {
			
			System.out.println("Enter the name: ");
			String i = scan.nextLine();
			name.add(i);
			count++;
			}
		System.out.println("LinkedList : "+name);
		
		ArrayList<String> nname = new ArrayList<String>(name);
		System.out.println("Converted LinkedList to ArrayList: "+nname);
		
		

	}

}
