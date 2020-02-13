//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{

	public static void main( String args[] )
	{
		StringEquality test = new StringEquality();

		test.setWords("word", "word");
		System.out.print(test.toString());
		test.setWords("thisIsAString", "alsoAString");
		System.out.print((test.toString()));
	}
}