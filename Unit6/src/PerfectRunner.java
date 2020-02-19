//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		Perfect g = new Perfect(496);
		System.out.println(g);
		g.setNumber(45);
		System.out.println(g);
		g.setNumber(6);
		System.out.println(g);
	}
}