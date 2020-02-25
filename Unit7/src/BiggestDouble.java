//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(0,0,0,0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double[] nums = {one, two, three, four};
		double biggest = nums[0];
		for(int i = 0; i < nums.length-2; i++)
		{
			if(nums[i] < nums[i+1])
				biggest = nums[i+1];
		}
		return biggest;
	}

	public String toString()
	{
		String numsList = one + ", " + two + ", " + three + ", " + four;
	   return numsList;
	}
}