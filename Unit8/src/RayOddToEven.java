//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] nums)
	{
		int firstOdd = nums[0];
		int oddPos = 0;
		int even = nums[0];
		int evenPos = 0;
		boolean oddAndEven = false;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] % 2 == 1)
			{
				firstOdd = nums[i];
				oddPos = i;
				for(int j = i; j < nums.length; j++)
				{
					if(nums[j] % 2 == 0)
					{
						even = nums[0];
						evenPos = j;
						oddAndEven = true;
						break;
					}
				
				}
				break;
			}
		}
		if(oddAndEven)
			return evenPos - oddPos;
		return -1;
	}
}