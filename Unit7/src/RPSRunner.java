//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		char response;
		
		String player = "";
		String yesNo = "y";
		
		//add in a do while loop after you get the basics up and running
		do {
			out.println("type in your prompt [R,P,S] :: ");
			player = scan.next();
			
			RockPaperScissors rps = new RockPaperScissors(player);
			out.println(rps);
			
			out.print("Would you like to play again? (y/n)");
			yesNo = scan.next();
			
		} while(yesNo.toUpperCase().equals("Y"));
			
		//read in the player value
//			out.println("type in your prompt [R,P,S] :: ");
//			player = scan.next();
//			
//			RockPaperScissors rps = new RockPaperScissors(player);
//			out.println(rps);
				
	}
}


