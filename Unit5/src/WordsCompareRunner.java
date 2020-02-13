//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		WordsCompare test = new WordsCompare();

		test.setWords("apple", "banana");
		test.compare();
		System.out.print(test.toString());
		test.setWords("carrot", "artichoke");
		test.compare();
		System.out.print(test.toString());
       test.setWords("2345", "98765");
       test.compare();
       System.out.print(test.toString());
   }
}