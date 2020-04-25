//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	private static int getNumDigits(int number)
	{
		int num = 0;
		int temp = number;
		while(temp/10 != 0)
		{
			num++;
			temp /= 10;
		}
		return num + 1;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int length = getNumDigits(number);
		int[] newArr = new int[length];
		
		for (int i = 0; i < length; i++)
		{
			newArr[i] = (number/(int)Math.pow(10, i)%10);
		}
		
		for (int i=1; i<length; i++)
		{
			int temp = newArr[i];
			int tester = i;
			
			while (tester > 0 && newArr[tester-1] > temp)
			{
				newArr[tester] = newArr[tester-1];
				tester--;
			}
			newArr[tester] = temp;
		}
		return newArr;
	}
}