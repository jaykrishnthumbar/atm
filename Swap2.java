import java.util.*;

public class swap2{
public static void main(String []Args){
	
	Scanner scan = new Scanner(System.in);
	int i=0,j=0;
	

	System.out.println("Enter the number1: ");
	i = scan.nextInt();
	System.out.println("Enter the number2: ");
	j = scan.nextInt();
	
	System.out.println("Before swapping: "+i);
	System.out.println("Before swapping: "+j);

	i = i+j;
	j = i-j;
	i = i-j;

	//i = i*j;
	//i = i/j;
	

	System.out.println("After swapping: "+i);
	System.out.println("After swapping: "+j);

}
}