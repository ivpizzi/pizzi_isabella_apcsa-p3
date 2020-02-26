//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class SumLastRunner
{
	public static void main( String args[] )
	{			
		RaySumLast test = new RaySumLast();
		
		int[] testArr = {-99,1,2,3,4,5,6,7,8,9,10,5};
		System.out.println(test.go(testArr));
		
		int[] testArr2 = {255, 255};
		System.out.println(test.go(testArr2));
		
		int[] testArr3 = {};
		System.out.println(test.go(testArr3));
		
		int[] testArr4 = {10,20,30,40,50,-11818,40,30,20,10};
		System.out.println(test.go(testArr4));
	}
}