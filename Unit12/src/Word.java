
public class Word implements Comparable<Word> {
	
    private String word;
    private int length;

    public Word(String s)
    {
        word = s;
        length = s.length();
    }

    public int compareTo(Word rhs)
    {
        int sizeA = length;
        int sizeB = rhs.word.length();

        if (sizeA > sizeB) {
            return 1;
        }
        else if (sizeB > sizeA)
        {
            return -1;
        }
        else
        {
            return word.compareTo(rhs.word);
        }
    }

    public String toString()
    {
        return word;
    }
}