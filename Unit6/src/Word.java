//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class Word
{
	private String word;

	public Word()
	{
		word = "";
	}

	public Word(String s)
	{
		setString(s);
	}

	public void setString(String s)
	{
		word = s;
	}

	public char getFirstChar()
	{
		return word.charAt(0);
	}

	public char getLastChar()
	{
		return word.charAt(word.length()-1);
	}

	public String getBackWards()
	{
		String back = "";
		for(int i = 0; i < word.length(); i++){
			back = back + String.valueOf(word.charAt((word.length() -1) - i));
		}
		return back;
	}

 	public String toString()
 	{
 		return "First character: " + getFirstChar() + ", Last character: " + getLastChar() + ", backwards: " + getBackWards();
	}
}