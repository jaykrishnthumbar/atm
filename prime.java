import java.util.*;

public class prime{
public static void main(String []Args){

	int count=0;
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter any number: ");
	int num = scan.nextInt();

	for(int i=1;i<=num;i++){
		if(num%i==0){
		count++;
		}
	}

	if(count==2){
	System.out.println("Prime number");
		}

	else{
	System.out.println("Not Prime number");
	}
}
}