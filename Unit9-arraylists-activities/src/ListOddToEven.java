//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		for (int i = 0; i < ray.size(); i++) {
            if (ray.get(i) % 2 > 0) {
                for (int j = ray.size() - 1; j > ray.indexOf(i); j--) {
                    if (ray.get(j) % 2 == 0) 
                        return (ray.lastIndexOf(ray.get(j)) - ray.indexOf(ray.get(i)));
                }
            }

        }
        return -1;
	}
}