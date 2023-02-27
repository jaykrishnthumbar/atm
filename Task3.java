package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		
		int count=0;
		ArrayList<String> name = new ArrayList<String>(); 
		Scanner scan = new Scanner(System.in);
		
		//synchronized
		Collections.synchronizedList(name);
		
		while(count<3) {
		
		System.out.println("Enter the name: ");
		String i = scan.nextLine();
		name.add(i);
		count++;
		}
		
		System.out.println(name);
		name.add(1,"nihar");
		System.out.println("Added element at particular index of ArrayList: ");
		System.out.println(name);
		
		
	}

}
