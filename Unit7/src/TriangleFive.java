//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter('A');
		setAmount(0);
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		
		int max = letter+amount;
		char currentLetter = letter;
		
		for(int i = letter;  i < max; i++)
		{
			if(i > 'Z')
			{
				i = 'A';
				letter = 'A';
				currentLetter = letter;
				max = 'A' - 2 + amount;
			}
			
			for(int j = amount; j > 0; j--)
			{
				output = output + " ";
				for(int k = amount; k > 0; k--)
				{
					output = output + currentLetter;
				}
				currentLetter++;
			}
			currentLetter = letter;
			output = output + "\n";
		}
		
		return output;
	}
}