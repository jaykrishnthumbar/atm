import java.util.*;

public class swap{
public static void main(String []Args){
	
	Scanner scan = new Scanner(System.in);
	int i,j,k;
	System.out.println("Enter the number1: ");
	i = scan.nextInt();
	System.out.println("Enter the number2: ");
	j = scan.nextInt();
	
	System.out.println("Before swapping: "+i);
	System.out.println("Before swapping: "+j);
	
	k=i;
	i=j;
	j=k;

	System.out.println("After swapping: "+i);
	System.out.println("After swapping: "+j);

}
}