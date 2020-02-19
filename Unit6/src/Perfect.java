//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number, total;

	//add constructors
	public Perfect(){
		number = 0;
		total = 0;
	}
	//add a set method
	public Perfect(int num){
		setNumber(num);
	}

	public void setNumber(int num) {
		number = num;
	}

	public boolean isPerfect()
	{
		for(int i = 1; i < number ; i++)
		{
			if(number % i == 0)
			{
				total = total + i;
			}
		}
		if(total == number)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString(){
		if(isPerfect())
			return number + " is perfect.";
		return number + " is not perfect.";
	}
	
}