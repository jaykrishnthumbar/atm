import java.util.*;

public class repetchar{
public static void main(String []Args){


	int count=0;
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the String: ");
	String name = scan.nextLine();

	System.out.println("Your given string= "+name);

	char str[] = name.toCharArray();
	HashSet<Character>value= new HashSet<Character>();

		for(int i=0;i<str.length-1;i++){
			for(int j=i+1;j<str.length-1;j++){
				if(str[i]==str[j] && str[i]!=' '){
				value.add(str[i]);
				}
			}
		}
		for(){
		
		}
		

	}
}