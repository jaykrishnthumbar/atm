package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		int i = 0;
		// TODO Auto-generated method stub
		
		ArrayList<String> sname = new ArrayList<String>();
	
		while(i<3) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name: ");
		String nname = scan.nextLine();
		sname.add(nname);
		i++;
		
		}
		System.out.println("Before sorting: " +sname);
		Collections.sort(sname);
		System.out.println("After sorting: " +sname);
	}

}
