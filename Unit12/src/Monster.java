
public interface Monster {
    int getHowBig();

    String getName();

    boolean isBigger(Monster other);
    boolean isSmaller(Monster other);
    boolean namesTheSame(Monster other);
}