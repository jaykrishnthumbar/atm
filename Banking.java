package com.practice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Banking {
	static User u1 = new User();
	public static void main(String[] args) throws SQLException {
		
		int choice=0;
		Scanner scan = new Scanner(System.in);
		
		try {
			while(choice!=8){
				System.out.println("Choose the option: ");
				System.out.println("1. Create account: ");
				System.out.println("2. Withdraw money: ");
				System.out.println("3. Deposit money: ");
				System.out.println("4. Check balence: ");
				System.out.println("5. Check User detail: ");
				System.out.println("6. Select the user you want to delete: ");
				System.out.println("7. Select the user you want to update: ");
				System.out.println("8. Exit: ");
				System.out.println();
				
				System.out.println("Enter Your Choice: ");
				choice=scan.nextInt();
				scan.nextLine();
				
				switch(choice) {
				
				case 1:u1.createAccount();
					break;	
					
				case 2:
					 {
					u1.withdrawMoney();
					}
					break;	
					
				case 3:
					{
					u1.depositMoney();
				}
					break;
					
				case 4:
					{
					u1.checkBalance();
					}
					break;	
					
				case 5:
					{
					u1.getUserDetails();
					}
					break;
					
				case 6:
					u1.deleteUser();
					break;	
						
				case 7:
					u1.updateUser();
					break;
					
				case 8:
					u1.closeConnection();
					System.exit(0);
					break;	
				default : System.out.println("\nEnter valid choice!!\n");
					}
				
				}
		}
		
		catch(Exception e){
			System.out.println("\nUser dose not exist!!");
			System.out.println("Please create new account!!\n");
			scan.nextLine();
			main(args);
		}
	}
}
