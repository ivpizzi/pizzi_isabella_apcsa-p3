//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(1);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int maxFactor = 0;
		int min = 1;
		if(b < a && b < c)
			min = b;
		else if(c < b && c < a)
			min = c;
		else
			min = a;
		
		for(int i = 1; i <= min; i++)
		{
			if(a % i == 0 && b % i == 0 && c % i == 0)
			{
				maxFactor = i;
			}
		}
		
		return maxFactor;
	}

	public String toString()
	{
		String output="";
		
		for(int a = 1; a <= number; a++)
		{
			for(int b = 1; b <= number; b++)
			{
				for(int c = 1; c <= number; c++)
				{
					if(a*a + b*b == c*c && greatestCommonFactor(a, b, c) == 1 && ((a % 2 == 0 && b % 2 == 1) || (a % 2 == 1 && b % 2 == 0)) && c % 2 == 1)
					{
						output = output + a + " " + b + " " + c + "\n";
					}
				}
			}
		}
		
		return output+"\n";
	}
}