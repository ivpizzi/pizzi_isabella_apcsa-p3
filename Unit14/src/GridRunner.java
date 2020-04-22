//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		Grid test = new Grid(3, 3, new String[] {"s", "g", "w"});
		
		System.out.println(test);
		System.out.println(test.findMax(new String[] {"v", "r", "e"}));
		
		
		Grid test2 = new Grid(6, 6, new String[] {"g", "2", "r", "d", "r", "f"});
		
		System.out.println(test2);
		System.out.println(test2.findMax(new String[] {"a", "w", "c", "a", "h", "i"}));
	}
}