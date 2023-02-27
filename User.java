package com.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
	
	private String admin_name;
	private String admin_pass;
	private String user_name;
	private double account_no;
	private char gender;
	private double balance;
	private String password;

	Scanner scan = new Scanner(System.in);
	static Connection conn = Database.getDatabaseConnection();
	
	
	
	public String getadmin_name() {
		return admin_name;
	}

	public void setadmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getadmin_pass() {
		return admin_pass;
	}

	public void setadmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {                                                                                                                                                                                                                   
		this.user_name = user_name;
	}


	public double getAccount_no() {
		return account_no;
	}

	public void setAccount_no(double account_no) {
		this.account_no = account_no;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getPassword() {
		return password;
	}
	
	private void setPassword(String password) {
		this.password = password;
		
	}
	
	String sql = "INSERT INTO Details VALUES (?,?,?,?)";
	public void createAccount() throws SQLException {
		try {
			conn.setAutoCommit(false);
			System.out.println("Enter User Name: ");
			 String user_name = scan.nextLine();
			 this.setUser_name(user_name);
			 System.out.println("Enter User Gender(m / f): ");
			 char gender = scan.next().charAt(0);
			 if(!(gender=='m' || gender=='f'))
			 {
				 throw new Exception();
			 }
			 this.setGender(gender);
			 System.out.println("Enter Balance: ");
			 double balance = scan.nextDouble();
			 this.setBalance(balance);
			 scan.nextLine();
			 System.out.println("Enter the password: ");
			 String password = scan.nextLine();
			 this.setPassword(password); 
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,this.getUser_name());
				ps.setString(2,String.valueOf(this.getGender()));
				ps.setDouble(3,this.getBalance());
				ps.setString(4,this.getPassword());
				ps.executeUpdate();
				
				System.out.println("You want to commit?(y/n)");
				String answer = scan.nextLine();
				if(answer.equals("y")){  
					System.out.println();
					System.out.println("Account created successfully..");
					System.out.println("Your user name: "+user_name);
					System.out.println("Your account number: "+account_no);
					System.out.println("Your gender: "+gender);
					System.out.println("Your account balance: "+balance);
					System.out.println();
					conn.commit();  
				}  
				else if(answer.equals("n")){ 
					System.out.println("Your data is not Stored!!");
					conn.rollback();  
				}   
				else {
					System.out.println("Enter valid answer!!");
				}
		}
		catch(Exception e){
			System.out.println("\nPlease enter valid data!!\n");
			scan.nextLine();
			}
	}

	

	public void depositMoney() throws SQLException {
		double money;
		String p="";
		try {
			System.out.println("Enter your account number: ");
			double account_no = scan.nextDouble();
			User user = checkaccount(account_no);
			System.out.println("Enter your account password: ");
			String password = scan.next();
			PreparedStatement ps = conn.prepareStatement("SELECT password FROM Details WHERE account_no ="+account_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			p = rs.getString("password");
			}
//			scan.nextLine();
			
			if(password.equals(p)) {
				System.out.println(user);
				System.out.println("Enter money you want to deposit: ");
				money=scan.nextDouble();
				scan.nextLine();
				String sql = "UPDATE Details set balance = ? where account_no = ?";
				balance=balance+money;
				user.setBalance(user.getBalance()+money) ;
				ps = conn.prepareStatement(sql);
				ps.setDouble(1, user.getBalance());
				ps.setDouble(2, user.getAccount_no());
				ps.executeUpdate();
				
				System.out.println("New balance: "+ user.getBalance());
		}
			else {
				System.out.println("Please enter valid password!!");
			}
	}
		catch(Exception e){
			System.out.println("\nPlease enter valid data!!\n");
			scan.nextLine();
			Banking.main(null);
		}
		
	}
	
	public void checkBalance() {
		try {
			System.out.println("Enter the account no you want to check balance: ");
			double account_no = scan.nextDouble();
			User user = checkaccount(account_no);
			System.out.println(user);
			System.out.println("balance: "+user.getBalance());
		}
		catch(Exception e){
			System.out.println("Please enter valid account number!!");
		}
	}

	@Override
	public String toString() {
		return "\nUser : [user_name=" + user_name + ", account_no=" + account_no + ", gender=" + gender + ", balance="
				+ balance + " Rs.]\n";
	}

	public void withdrawMoney() throws SQLException {
		double money;
		String p="";
		
		try {
			System.out.println("Enter the account no you want to select: ");
			double account_no = scan.nextDouble();
//			Boolean acc =  accountExist(account_no);
			User user = checkaccount(account_no);
			System.out.println("Enter your account password: ");
			String password = scan.next();
			PreparedStatement ps = conn.prepareStatement("SELECT password FROM Details WHERE account_no ="+account_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			p = rs.getString("password");
			}
			
			if(password.equals(p)) {
				System.out.println(user);
				System.out.println("Enter money you want to withdraw: ");
				money=scan.nextDouble();
				scan.nextLine();
				balance=balance-money;
				String sql = "UPDATE Details set balance = ? where account_no = ?";
			
			if(money<user.getBalance()) {
				user.setBalance(user.getBalance()-money) ;
				PreparedStatement ps2 = conn.prepareStatement(sql);
				ps2.setDouble(1, user.getBalance());
				ps2.setDouble(2, user.getAccount_no());
				ps2.executeUpdate();
				
				System.out.println("New balance: "+ user.getBalance());
			}
			else {
				System.out.println("\nInsufficient money!!\n");
			}
			}
			else {
				System.out.println("Please enter valid password!!");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("\nPlease enter valid data!!\n");
			scan.nextLine();
			Banking.main(null);
		}
		}

	private User checkaccount(double account_no2) throws SQLException {
		User user = new User();
		boolean flag = false;
		try {
			String sql = "SELECT * FROM Details";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {	
				if(rs.getDouble("account_no")==(account_no2)) {
					flag = true;
					user.setUser_name(rs.getString("emp_id"));
					user.setAccount_no(account_no2);
					user.setBalance(rs.getDouble("balance"));
					user.setGender(rs.getString("gender").charAt(0));
				}	
			}
			if(flag==false) {
				throw new Exception ();
			}
	}
		catch(Exception e) {
			System.out.println("Enter valid account no!!");
			scan.nextLine();
			Banking.main(null);
		}
		return user;
	}
	
	public void deleteUser() {		
		try {
			
			System.out.println("Enter user account no you want to delete: ");
			Double account_no = scan.nextDouble();
			User user = checkaccount(account_no);
			
			if(!user.getUser_name().equals(null)) {
				System.out.println("Are you sure you want to delete your data?(y/n)");
				Scanner scan = new Scanner(System.in);
				char ans=scan.next().charAt(0);
				if(ans=='y') {
					String sql = "DELETE FROM Details WHERE account_no = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setDouble(1,account_no);
					ps.executeUpdate();
					System.out.println("Successfully deleted..");
				}
				else if(ans=='n'){
					System.out.println("Your data is not deleted!!");
				}
			}
			
//			else {
//				System.out.println("Enter valid account number!!");
//			}
			
		}
		catch(Exception e) {
			System.out.println("Enter valid account number!!");
		}	
	}
	
	public void closeConnection() throws SQLException {
		
		System.out.println("Are you sure you want to exit? (y/n)");
		Scanner exit = new Scanner(System.in);
		char ans=scan.next().charAt(0);
		if(ans=='y') {
			System.out.println("Thank you for connecting with us..");
			conn.close();
		}
		else if(ans=='n') {
			Banking.main(null);
			System.out.println("Ok....Thank you...");
		}	
		else {
			System.out.println("Enter valid choice!!");
			Banking.main(null);
		}
		
	}

	public void updateUser() {
		
		try { 
			System.out.println("Enter account number you want to update: ");
			double account_no = scan.nextDouble();
			
			User user = checkaccount(account_no);
			if(!user.getUser_name().equals(null)) {
				scan.nextLine();
				System.out.println(user);
				System.out.println("Enter User Name: ");
				 String user_name = scan.nextLine();
				 System.out.println("Enter User Gender(m / f): ");
				 char gender = scan.next().charAt(0);
				 System.out.println("Are you sure you want to update your data?(y/n)");
				 Scanner scan = new Scanner(System.in);
				 char ans=scan.next().charAt(0);
		
				if(ans=='y') {
				 if(!(gender=='m' || gender=='f'))
				 {
					 throw new Exception();
				 }
				user.setGender(gender);
				user.setUser_name(user_name);
				String sql = "UPDATE Details SET emp_id = ? , gender = ? WHERE account_no = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user_name);
				ps.setString(2,Character.toString(gender));
				ps.setDouble(3, account_no);
//				scan.nextLine();
				ps.executeUpdate();
				System.out.println("Your data is updated..");
				 }
				else if(ans=='n') {
					System.out.println("Your data is not update");
				}
			}
		}
		catch(Exception e){
			System.out.println("Please enter valid account number!!");
		}
	}
	
//	public static boolean accountExist(double account_no) {
//		boolean flag = false;
//		String sql = "SELECT account_no FROM Details ";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			ArrayList<Long> number = new ArrayList<Long>();
//			while(rs.next()){
//				number.add(rs.getLong("account_no"));
//			}
//			flag = number.contains(account_no);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return flag;
//	}

	public void getUserDetails() {
		try {
		System.out.println("Enter user account no: ");
		Double account_no = scan.nextDouble();
		User user = checkaccount(account_no);
		
		if(!user.getUser_name().equals(null)) {
			System.out.println(user);
		}
		}
		catch(Exception e) {
			
		}
	}
}
