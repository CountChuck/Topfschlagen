public class Topfschlagen
{
	static boolean[][] arr;
	
	public static int Orakel(boolean[][] arr, int i1, int j1, int i2, int j2)
	{
		for(int i = i1; i >= i2; i--)
		{
			for(int j = j1 ; j <= j2; j++)
			{
				System.out.println(i + " "+ j);
				if(arr[i][j])
				{
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static int[] search(boolean[][] arr, int i1, int j1, int i2, int j2)
	{
		if(arr[i1][j1])
		{
			int[] result = {i1, j1};
			return result;
		}
		else
		{
			if(arr.length%2 == 0)
			{
				if(Orakel(arr,arr.length/2-1,j1,i2,j2)==1)
				{
					return search(arr, arr.length/2-1, j1, i2, j2);
				}
				else
				{
					return search(arr, i1,j1,arr.length/2,j2);
				}
			}
			else
			{
				if(Orakel(arr,i1,arr[i1].length/2-1,i2,j2)==1)
				{
					return search(arr, i1,arr[i1].length/2-1,i2,j2);
				}
				else
				{
					return search(arr, i1,j1,i2,arr[i2].length/2);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		arr = new boolean[4][4];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				arr[i][j] = false;
			}
		}
		arr[3][0] = true;
		//System.out.println(Orakel(arr,3,0,0,1));
		int[] res = search(arr,3,0,0,3);
		System.out.println(res[0] + " " + res[1]);
	}
}