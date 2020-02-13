//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
		String last = a.substring(a.length()-1, a.length());
		String first = a.substring(0, 1);
		if(last.equals("a") || last.equals("e") || last.equals("i") || last.equals("o") || last.equals("u") || last.equals("A") || last.equals("E") || last.equals("I") || last.equals("O") || last.equals("U"))
		{
			return "yes";
		}
		if(first.equals("a") || first.equals("e") || first.equals("i") || first.equals("o") || first.equals("u") || first.equals("A") || first.equals("E") || first.equals("I") || first.equals("O") || first.equals("U"))
		{
			return "yes";
		}
		return "no";
	}
}