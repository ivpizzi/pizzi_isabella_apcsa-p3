//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RaySumLast
{
	public static int go(int[] arr)
	{
		int sum = 0;
		
		for(int i = 0; i < arr.length-1; i++)
		{
			if(arr[i] > arr[arr.length-1])
			{
				sum += arr[i];
			}
		}
		if(sum == 0)
			return -1;
		else return sum;
	}
}