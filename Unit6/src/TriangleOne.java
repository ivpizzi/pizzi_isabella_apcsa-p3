//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOne
{
	private String str;

	public TriangleOne()
	{
		str="";
	}

	public TriangleOne(String s)
	{
		setWord(s);
	}

	public void setWord(String s)
	{
		str=s;
	}

	public void print( )
	{
		for(int i = 0; i < str.length(); i++)
		{
			System.out.println(str.substring(0, str.length() - i));
		}
	}
}