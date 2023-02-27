package com.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		HashMap<String,Integer> sname = new HashMap<String,Integer>();
		int count = 0;
		while(count<3) {
			System.out.println("Enter the name: ");
			String name = scan.nextLine();
			System.out.println("Enter the value: ");
			int j = scan.nextInt();
			scan.nextLine();
			
			sname.put(name, j);
			count++;
		}
		System.out.println(sname);
		
		System.out.println("Compare by key: ");
		sname.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.nullsFirst(Comparator.naturalOrder()))).forEach(x->System.out.println(x));
		System.out.println("Compare by value: ");
		sname.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.nullsFirst(Comparator.naturalOrder()))).forEach(x->System.out.println(x));

	}

}
