/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card nineOfClubs = new Card("9", "Clubs", 9);
		System.out.println(nineOfClubs);
		
		Card fiveOfSpades = new Card("5", "Spades", 5);
		System.out.println(fiveOfSpades);
		
		Card queenOfHearts = new Card("Queen", "Hearts", 12);
		System.out.println(queenOfHearts);
	}
}