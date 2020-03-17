//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class ToyRunner
{
	public static void main(String[] args)
	{
		Toy test = new Toy("teddy bear");
		test.setCount(3);
		System.out.println(test);
		
		Toy test2 = new Toy("doll");
		test2.setCount(5);
		System.out.println(test2);
	}
}