//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayDown
{
	/*
	 * go() will return true if all numbers in numArray
	 * are in decreasing order [31,12,6,2,1]
	*/
	public static boolean go(int[] numArray)
	{
		boolean goesDown = true;
		int previous = numArray[0];
		for(int i = 0; i < numArray.length-1; i++)
		{
			if(numArray[i+1] <= numArray[i])
				previous = i+1;
			else
			{
				goesDown = false;
				break;
			}
		}
		return goesDown;
	}	
}