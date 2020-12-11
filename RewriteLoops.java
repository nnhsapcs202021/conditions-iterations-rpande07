
import java.util.Scanner;
/**
 * Write a description of class RewriteLoops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RewriteLoops
{
   

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int while1()
    {
        int s = 0;
        int i = 1;
        while (i <= 10)
        {
            s = s + i;
            i++;
        }
        return s;
    }

    public int for1()
    {
        int s = 0;
        int i;
        for ( i = 1; i <= 10; i++)
        {
            s = s + i;
        }
        return s;
    }
    public double doWhile()
    {
        Scanner in = new Scanner( System.in );
        System.out.print("Enter an integer: ");
        int n = in.nextInt();
        double x = 0;
        double s;
        do
        {
            s = 1.0 / (1 + n * n);
            n++;
            x = x + s;
        }
        while (s > 0.01);
        return x;
    }

    public double while2()
    {
        Scanner in = new Scanner( System.in );
        System.out.print("Enter an integer: ");
        int n = in.nextInt();
        double x = 0;
        double s = 1.0 / (1 + n * n);
        while (s > 0.01)
        {
            s = 1.0 / (1 + n * n);
            n++;
            x = x + s;
        }

        return x;
    }
}

