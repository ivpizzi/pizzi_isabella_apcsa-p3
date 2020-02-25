//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;
	
	Random rand = new Random();

	public RockPaperScissors()
	{
		setPlayers("");
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
		int randChoice = rand.nextInt(3);
		if(randChoice == 0)
			compChoice = "R";
		else if (randChoice == 1)
			compChoice = "P";
		else if (randChoice == 2)
			compChoice = "S";
	}

	public String determineWinner()
	{
		String winner = "";
		
		if(playChoice.equals("R"))
		{
			if(compChoice.equals("R"))
				winner = "Tie!";
			else if(compChoice.equals("P"))
				winner = "Computer wins! Paper covers rock.";
			else if (compChoice.equals("S"))
				winner = "Player wins! Rock breaks scissors";
				
		}
		else if (playChoice.equals("P"))
		{
			if(compChoice.equals("R"))
				winner = "Player wins! Paper covers rock.";
			else if(compChoice.equals("P"))
				winner = "Tie!";
			else if (compChoice.equals("S"))
				winner = "Computer wins! Scissors cut paper.";
		}
		else if (playChoice.equals("S"))
		{
			if(compChoice.equals("R"))
				winner = "Computer wins! Rock breaks scissors.";
			else if(compChoice.equals("P"))
				winner = "Player wins! Scissors cut paper.";
			else if (compChoice.equals("S"))
				winner = "Tie!";
		}
		else
			winner = "Computer wins! Player did not enter anything.";
		
		return winner;
	}

	public String toString()
	{
		String output = determineWinner();
		return "Player had " + playChoice + "\nComputer had " + compChoice + "\n" + output;
	}
}