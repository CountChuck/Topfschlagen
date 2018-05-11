public class Topfschlagen
{
	static boolean[][] arr;
	
	public static int Orakel(int i1, int j1, int i2, int j2)
	{
		for(int i = i1; i < arr.length; i++)
		{
			for(int j = j1 ; j < arr[i2].length; j++)
			{
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
		if(arr.length == 1 && arr[i1].length == 1)
		{
			int[] result = {i1, j1};
			return result;
		}
		else
		{
			if(arr.length%2 == 0)
			{
				if(Orakel(arr.length/2-1,j1,i2,j2)==1)
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
				if(Orakel(i1,arr[i1].length/2-1,i2,j2)==1)
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
		arr = new boolean[8][8];
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
			{
				arr[i][j] = false;
			}
		}
		arr[1][1] = true;
		search(arr,7,0,0,7);
	}
}