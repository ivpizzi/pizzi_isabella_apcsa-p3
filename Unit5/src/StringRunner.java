//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("Enter a word :: ");
		String input = scanner.next();
		StringOddOrEven str = new StringOddOrEven(input);
		System.out.print("The word " + input + " is " + str.toString());
	}
}