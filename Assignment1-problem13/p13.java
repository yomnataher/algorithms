public class Globals
{
	public static void MatrixChain(int n, int[] p, int[][] m, int[][] s)
	{
		int i;
		int j;
		int k;
		int r;
		int t;
		for (i = 1; i <= n; i++)
		{
			m[i][i] = 0;
		}
		for (r = 2; r <= n; r++)
		{
			for (i = 1; i <= n - r + 1; i++)
			{
				j = i + r - 1;
				m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
				s[i][j] = i;
				for (k = i + 1; k < j; k++)
				{
					t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (t < m[i][j])
					{
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}
	public static void output(int i, int j, int[][] s)
	{
		if (i == j)
		{
			System.out.printf("A%d", i);
		}
		else
		{
			System.out.print("(");
			output(i, s[i][j], s);
			System.out.print(" x ");
			output(s[i][j] + 1, j, s);
			System.out.print(")");
		}
	}
	public static void main(String[] args)
	{
		int i;
		int n;
		int ca = 1;
		int[] p = new int[11];
		int[][] m = new int[11][11];
		int[][] s = new int[11][11];
		while (scanf("%d", n), n)
		{
			for (i = 1; i <= n; i++)
			{
				String tempVar = ConsoleInput.scanfRead();
				if (tempVar != null)
				{
					p[i - 1] = Integer.parseInt(tempVar);
				}
				String tempVar2 = ConsoleInput.scanfRead(" ");
				if (tempVar2 != null)
				{
					p[i] = Integer.parseInt(tempVar2);
				}
			}
			MatrixChain(n, p, m, s);
			System.out.printf("Case %d: ", ca++);
			output(1, n, s);
			System.out.print("\n");
		}
	}
}