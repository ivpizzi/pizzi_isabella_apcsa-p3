//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "";
	}

	public LetterRemover(String s, char letter)
	{
		setRemover(s, letter);
	}
	
	
	public void setRemover(String s, char letter)
	{
		sentence = s;
		lookFor = letter;
	}

	public String removeLetters()
	{
		String cleaned = sentence.replaceAll(String.valueOf(lookFor), "");

		return cleaned;
	}

	public String toString()
	{
		return removeLetters() + " - letter to remove " + lookFor;
	}
}