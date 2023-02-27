import java.util.*;

public class palindrome{
public static void main(String []Args){

	int rem,n1,rev=0;
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number: ");
	int num = scan.nextInt();
	n1=num;

	while(num>0){
	rem=num%10;
	rev=rev*10+rem;
	num=num/10;	
	}
	if(n1==rev){
	
	System.out.println("palindrome");}

	else{
	
	System.out.println("not palindrome");}
	
}
}