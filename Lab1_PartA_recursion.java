import java.util.Scanner;

public class Lab1_PartA_recursion {

	/**
	 * @param args
	 */
	
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
				
		int greaterCD;
		
		
		System.out.println("input two integers: ");
		int m = keyboard.nextInt();
		int n = keyboard.nextInt();
		
		//call gcd function
		greaterCD = gcd(m, n);
		System.out.println("the gcd :" + greaterCD);
		System.out.println("the number of recursion: " + count);
		

	}
	
	public static int gcd(int m, int n)
	{
		int r;
		count++;      //count the time of recursion
		r = m % n;
		System.out.println("m = " + m + "; n = " + n + "; r = " + r);
		//base case
		if (r == 0)
		{
			return n;
		}
		
		//recursive case
		else
		{
			return gcd(n, r);
		}
		
	}
	

}

