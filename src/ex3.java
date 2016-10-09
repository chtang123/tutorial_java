import java.util.Arrays;

public class ex3 {
	public static void main(String [] args)
	{
	 int numbers [ ] = new int [20];	
	 numbers[0] = 1;
	 int i = 1;
	 while (i<=19)
	 {
		numbers[i]= 2*numbers[i-1];
		i++;
	 }
	 System.out.println(Arrays.toString(numbers));
	}
}
