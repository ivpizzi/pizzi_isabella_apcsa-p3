import java.util.Scanner;

public class MonsterRunner {
	
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Name the first monster");
        String firstname = keyboard.nextLine();

        System.out.println("What is the size of the first monster?");
        int firstSize = keyboard.nextInt();

        System.out.println("Name the second monster");
        String secondname = keyboard.next();

        System.out.println("What is the size of the second monster?");
        int secondSize = keyboard.nextInt();

        Monster m = new Skeleton(firstSize, firstname);
        Monster mon = new Skeleton(secondSize, secondname);
        System.out.println("Monster 1 - " + m);
        System.out.println("Monster 2 - " + mon);
        
        if (m.isBigger(mon))
        {
            System.out.println("Monster one is bigger");
        }
        else if (mon.isBigger(m))
        {
            System.out.println("Monster two is bigger");
        }
        
        if (m.namesTheSame(mon) || mon.namesTheSame(m)) {
            System.out.println("The monsters have the same name");
        }
        else
        {
            System.out.println("The monsters have different names");
        }
    }
}