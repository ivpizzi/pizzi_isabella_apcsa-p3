//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RecursionFunThree
{

	public static int luckyThrees(long number)
	{
		if (number < 10)
		{
			return 0;
		}
		
		if (number % 10 == 3)
		{
			return luckyThrees(number/10)+1;
		} else return luckyThrees(number/10);
	}
}