/**
 * Write a description of class Diamond here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Diamond
{
    public static void asterisks()
    {
        int sideLength = 5;
        int max = (sideLength*2) - 1;
        //first half of the for loop
        for(int j = 1; j <= ((sideLength*2) - 1); j +=2)
        {
            int spaces = (max - j)/2;
            for(int spaceCounter = spaces; spaceCounter > 0; spaceCounter -=1)
            {
                System.out.print(" ");
            }
            for(int starCounter = j; starCounter > 0; starCounter -= 1)
            {
                if(starCounter == 1)
                {
                    System.out.println("*");
                }
                else
                {
                    System.out.print("*");
                }
            }
        }
        int shorter = sideLength -1;
        for(int stars = max-2; stars <= (shorter*2 - 1); stars -=2)
        {
            int spaces = (max - stars)/2;
            for(int spaceCounter = spaces; spaceCounter > 0; spaceCounter -=1)
            {
                System.out.print(" ");
            }
            for(int starCounter = stars; starCounter > 0; starCounter -= 1)
            {
                if(starCounter == 1)
                {
                    System.out.println("*");
                }
                else
                {
                    System.out.print("*");
                }
            }
        }
    }  
}