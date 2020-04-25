//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array(int size)
	{
		Random rand = new Random();
		int[] array7 = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			int randNum = rand.nextInt(9)+1;
			array7[i] = randNum;
		}
		
		return array7;
	}
	
	public static void shiftEm(int[] array)
	{
		int shift = 0;
		
		while (array[shift] == 7)
		{
			shift++;
		}
		
		for (int i = 0; i < array.length; i++)
		{
			if (array[i]==7) 
			{
				int temp = array[i];
				array[i]=array[shift];
				array[shift]=temp;
				shift++;
			}
		}
	}
}