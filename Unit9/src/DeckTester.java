/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck(new String[] {"1", "2", "3", "4", "5"}, new String[] {"Diamonds"}, new int[] {1, 2, 3, 4, 5});
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
	}
}