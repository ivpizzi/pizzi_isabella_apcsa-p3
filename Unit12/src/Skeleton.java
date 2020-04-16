
public class Skeleton implements Monster {


    private final int size;
    private final String name;


    public Skeleton(int s, String n)
    {
        size = s;
        name = n;
    }


    @Override
    public int getHowBig()
    {

        return size;
    }

    @Override
    public String getName()
    {

        return name;
    }

    @Override
    public boolean isBigger(Monster other)
    {

        return size > other.getHowBig();
    }

    @Override
    public boolean isSmaller(Monster other)
    {

        return size < other.getHowBig();
    }

    @Override
    public boolean namesTheSame(Monster other)
    {

        return name.equals(other.getName());
    }


    public String toString()
    {
        return "" + getName() + " " + getHowBig();
    }
}