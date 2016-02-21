import java.util.Scanner;

public class Lab1_PartA {

	/**
	 * @param args
	 */
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		int r;
				
		System.out.println("input two integers: ");
		int m = keyboard.nextInt();
		int n = keyboard.nextInt();
		
		while ((r = m % n) != 0)
		{
			m = n;
			n = r;
			count++;
		}
		
		System.out.println("the gcd :" + n);
		System.out.println("the number of loops: " + count);

	}

}

