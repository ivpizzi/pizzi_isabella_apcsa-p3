//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
	}
	
	public void set(int spot, int age, String name)
	{
		//put a new Dog in the array at spot
		//make sure spot is in bounds
		if(spot < pups.length && spot >= 0)
			pups[spot] = new Dog(age, name);
	}

	public String getNameOfOldest()
	{
		int maxAge = 0;
		int maxAgeIndex = 0;
		for(int i = 0; i < pups.length; i++)
		{
			if(pups[i].getAge() > maxAge)
			{
				maxAge = pups[i].getAge();
				maxAgeIndex = i;
			}
		}
		return pups[maxAgeIndex].getName();
	}

	public String getNameOfYoungest()
	{
		int minAge = pups[0].getAge();
		int minAgeIndex = 0;
		for(int i = 0; i < pups.length; i++)
		{
			if(pups[i].getAge() < minAge)
			{
				minAge = pups[i].getAge();
				minAgeIndex = pups[i].getAge();
			}
		}
		return pups[minAgeIndex].getName();
	}

	public String toString()
	{
		return "" + Arrays.toString(pups);
	}
}