
public class Lab2_PartA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// use 2 separate methods to implement bruteForce and improved MCS algorithms
		
		int[] a = {-1, -2, -3, -4, -5, -6};
		int[] b = {-1, 1, -1, 1, -1, 1};
		int[] c = {-1, 2, 3, -3, 2};
		int[] d = {1, -5, 2, -1, 3};
		int[] e = {-2, 2, -2, -2, 3, 2};
		int j;
		System.out.println("\t\t\t\t\t bruteForce \t\t\t\t improved");
		bruteForce(a);
		improved(a);
		bruteForce(b);
		improved(b);
		bruteForce(c);
		improved(c);
		bruteForce(d);
		improved(d);
		bruteForce(e);
		improved(e);
	}
	
	public static void bruteForce(int[] a)
	{
		int i, j, sum, maxSum = 0, start = -1, end = -1, count = 0;
		int arrayLength = a.length;
		for (j = 0; j < arrayLength; j++)
		{
			System.out.print(a[j]);
			if (j < arrayLength - 1) System.out.print(", ");
		}
		System.out.printf("\t\t");
		// loop of i
		for (i = 0; i < arrayLength; i++)
		{
			sum = 0;
			
			// loop of j
			for (j = i; j < arrayLength; j++)
			{
				count++;
				// compare sum with maxSum, if sum > maxSum, update maxSum and mark the position of i, j
				sum += a[j];
				if (sum > maxSum)
				{
					maxSum = sum;
					start = i;
					end = j;
				}
				
			}
			
		}
		//output the maxSum MCS
		System.out.print("MCS: ");
		if (start < 0)
		{
			System.out.printf("%d", 0);
		}
		else
		{
			for (j = start; j <= end; j++) 
			{
				System.out.print(a[j]);
				if (j < end) System.out.print(", ");
			}
		}
		System.out.printf("; loop times: %d\t\t", count);

		//System.out.println();
	}
	
	public static void improved(int[] a)
	{
		int i, j, sum, maxSum = 0, start = -1, end = -1, count = 0;
		int arrayLength = a.length;
		j = i = 0;
		sum = 0;
		// while loop of j
		while (j < arrayLength)
		{
			count++;
			sum += a[j];
			if (sum > maxSum)
			{
				maxSum = sum;
				start = i;
				end = j;
			}
			// when sum <= 0, reset i 
			if (sum <= 0)
			{
				sum = 0;
				i = j + 1;
			}
			j++;
		}
		//output the maxSum MCS
		System.out.print("MCS: ");
		if (start < 0)
		{
			System.out.print(0);
		}
		else
		{
			for (j = start; j <= end; j++) 
			{
				System.out.print(a[j]);
				if (j < end) System.out.print(", ");
			}
		}
		System.out.printf("; loop times: %d", count);
		System.out.println();
	}

}
