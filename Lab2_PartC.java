
public class Lab2_PartC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// assume the given matrix has the size of m * n
		int[][] matrix = {{2, -4, 8, 8}, {0, -3, 8, 8}, {1, 2, 0, 1}};
		int m = 3, n = 4;
		// set i as the row index, set j as the column index, set maxSum to 0, mark row(-1, -1) (start, end), column(-1, -1)
		int i, j, k, l, o, sum, maxSum = 0, rowStart = -1, rowEnd = -1, columnStart = -1, columnEnd = -1;
		
		System.out.println("the input matrix:");
		for (i = 0; i < m; i++)
		{
			for (j = 0; j < n; j++)
			{
				System.out.printf("%d \t", matrix[i][j]);
			}
			System.out.println();
		}
		// loop of i (0 to m - 1),
		for (i = 0; i < m; i++)
		{
			// loop of k (i to m - 1)
			for (k = 0; k < m; k++)
			{
				// if i = k, 1 row MCS				
				// else (i < k), (k - i + 1) row MCS
				// set sum to 0,
				sum = 0;
				// set j to 0
				l = j = 0;
				// loop of l (0 to n - 1)
				while (l < n)
				{
					// loop o (i to k)
					for (o = i; o <= k; o++)
					{
						// sum = sum + a[o][l]
						sum += matrix[o][l];
					}
					// if sum > maxSum,					
					// update maxSum, mark row(i, k) & column(j, l)
					if (sum > maxSum)
					{
						maxSum = sum;
						rowStart = i;
						rowEnd = k;
						columnStart = j;
						columnEnd = l;
					}
					// if sum < 0, 
					// set j to l + 1;
					
					if (sum < 0)
					{
						sum = 0;
						j = l + 1;						
					}
					l++;


				}



			}

				
		}
		System.out.println("MCS:");
		for (i = rowStart; i <= rowEnd; i++)
		{
			for (j = columnStart; j <= columnEnd; j++)
			{
				System.out.printf("%d \t", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("maxSum:" + maxSum);
		System.out.println("row(" + rowStart + ", "+ rowEnd + ")" + "column(" + columnStart + ", " + columnEnd + ")");
		

	}

}
