public class Topfschlagen
{
	static boolean[][] arr;
	
	public static int Orakel(int i1, int j1, int i2, int j2)
	{
		for(int i = i1; i >= i2; i--)
		{
			for(int j = j1 ; j <= j2; j++)
			{
				//System.out.println(i + " "+ j);
				if(arr[i][j])
				{
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static int[] search(int i1, int j1, int i2, int j2)
	{
		if(arr[i1][j1])
		{
			int[] result = {i1, j1};
			return result;
		}
		else
		{
			if(j1 != j2)
			{
				if(Orakel(i1,j1,i2,j2/2)==1)
				{
					return search(i1, j1, i2, j2/2);
				}
				else
				{
					return search(i1,j2/2+1,i2,j2+1);
				}
			}
			else
			{
				if(Orakel(i1/2,j1,i2,j2)==1)
				{
					return search(i1/2,j1,i2,j2);
				}
				else
				{
					return search(i1-1,j1,i1/2-1,j2);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		arr = new boolean[8][8];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				arr[i][j] = false;
			}
		}
		arr[3][3] = true;
		//System.out.println(Orakel(arr,3,0,0,3));
		
		long tStart, tEnd, lmsecsrt;
		tStart = System.currentTimeMillis();
		int[] res = search(7,0,0,7);
		tEnd = System.currentTimeMillis();
		lmsecsrt = (tEnd - tStart);
		float msecsrt = (float)lmsecsrt/(float) 1000;
		
		System.out.println(msecsrt);
		System.out.println(res[0] + " " + res[1]);
	}
}