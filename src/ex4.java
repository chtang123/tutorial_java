import java.util.Scanner; 

public class ex4 {

	public static void main(String [] args)
	{
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		 System.out.println("tell me how many bytes is that , i'll convert for you ");
		 float k = reader.nextFloat(); // Scans the next token of the input as an int.
		
		 float kb = k/1024;
		 float mb = k/1048576;
		 float gb = k/ 1073741824;
		 
		 
		 
		 
		 
		 
		 System.out.println("you tell me " +k +"  bytes" );
		 System.out.println("I convert that to " +kb +"KB");
		 System.out.println("I convert that to " +mb +"MB");
		 System.out.println("I convert that to " +gb +"GB");
		 
		 
	}
}
