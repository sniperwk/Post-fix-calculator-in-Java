
public class Lab2_PartB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {-1, -2, -3, -4, -5, -6};
		int[] b = {-1, 1, -1, 1, -1, 1};
		int[] c = {-1, 2, 3, -3, 2};
		int[] d = {1, -5, 2, -1, 3};
		int[] e = {-2, 2, -2, -2, 3, 2};
		int j;
		System.out.println("\t\t\t\t\t improved (right to left) \t\t improved (left to right)");
		improvedFromRight(a);
		Lab2_PartA.improved(a);
		improvedFromRight(b);
		Lab2_PartA.improved(b);
		improvedFromRight(c);
		Lab2_PartA.improved(c);
		improvedFromRight(d);
		Lab2_PartA.improved(d);
		improvedFromRight(e);
		Lab2_PartA.improved(e);
	}
	public static void improvedFromRight(int[] a)
	{
		int i, j, sum, maxSum = 0, start = -1, end = -1, count = 0;
		int arrayLength = a.length;
		
		for (j = 0; j < arrayLength ; j++)
		{
			System.out.print(a[j]);
			if (j < arrayLength - 1) System.out.print(", ");
		}
		System.out.printf("\t\t\t");
		
		j = i = arrayLength - 1;
		sum = 0;
		// while loop of j
		while (i >= 0)
		{
			count++;
			sum += a[i];
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
				j = i - 1;
			}
			i--;
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
		System.out.printf("; loop times: %d\t\t\t", count);
	}

}
