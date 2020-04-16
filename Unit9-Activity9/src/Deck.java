
public class Deck {


    private Card[] cards;


    private int size;


    public Deck(String[] ranks, String[] suits, int[] values) {


        cards = new Card[ranks.length * suits.length];
        int i = 0;

        for (int j = 0; j < ranks.length; j++) {
            for (int k = 0; k < suits.length; k++) {
                Card aCard = new Card(ranks[j], suits[k], values[j]);
                cards[i] = aCard;
                i++;
            }
        }
        shuffle();
        size = cards.length;
    }


    public boolean isEmpty() {

        return size == 0;
    }


    public int size() {

        return size;
    }


    public void shuffle() {

        for (int k = cards.length - 1; k > 0; k--) {
            int howMany = k + 1;
            int start = 0;
            int randPos = (int) (Math.random() * howMany) + start;
            Card temp = cards[k];
            cards[k] = cards[randPos];
            cards[randPos] = temp;
            size = cards.length;
        }
    }


    public Card deal() {

        if (isEmpty() == true) return null;
        size--;
        Card returned = cards[size];
        return returned;
    }


    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards[k];
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {

                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.length - 1; k >= size; k--) {
            rtn = rtn + cards[k];
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.length) % 2 == 0) {

                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}