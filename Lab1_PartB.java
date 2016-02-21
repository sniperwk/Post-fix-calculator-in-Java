import java.util.Scanner;

public class Lab1_PartB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		
		int gcd;
		
		
		System.out.println("input two integers: ");
		int a = keyboard.nextInt();
		int b = keyboard.nextInt();
		
		//call gcdGet function
		if (a < b)
		{
			gcd = gcdGet(b, a);
		}
		else // m >= n
		{
			gcd = gcdGet(a, b);
		}
		
		System.out.println("the gcd :" + gcd);
		// System.out.println("the number of recursion: " + count);

	}
	
	public static int gcdGet(int m, int n)
	{
		//base case
		if (m == n)
		{
			return m;
		}
		
		else if (m == 1 || n == 1)
		{
			return 1;
		}
		//recursive case
		else if (m % 2 == 0 && n % 2 == 0)
		{
			return 2 * gcdGet(m / 2, n / 2);
		}
		else if (m % 2 == 0)
		{
			return gcdGet(m / 2, n);
		}
		else if (n % 2 == 0)
		{
			return gcdGet(m, n / 2);
		}
		else if (m > n)
		{
			return gcdGet((m + n) /2, (m - n) / 2);
		}
		else // m < n
		{
			return gcdGet((m + n) / 2, (n - m) /2);
		}
	}
	
}

