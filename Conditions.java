import java.util.Scanner;
/**
 * Examples and notes on conditions (Chapter 5)
 *
 * @author mrcallaghan
 * @version 19nov2020
 */
public class Conditions
{
    public static void ifExample()
    {
        // model a coin flip; 1: heads, 0: tails
        int coinFlip = (int)(Math.random() * 2);

        /*
         * if statement
         *  Statements are executed if the conditional expression is true.
         *  
         *  Conditional expressions evaluate to either true or false.
         *  The conditional expression must go inside of parentheses.
         *  Statements are grouped by blocks (i.e., { }), not by indentation like in Python.
         *  There is no colon after the conditional expression, unlike Python.
         * 
         */
        if (coinFlip == 1)
        {
            System.out.println("Coin is heads!");

        }

        /*
         * if-else statement
         *  The else block is executed if the condition evaluates to false.
         */

        if (coinFlip == 1)
        {
            System.out.println("Coin is heads!");

        }
        else
        {
            System.out.println("Coin is tails!");
        }

        // model the roll of a four-sided die [1-4]
        int dieRoll = (int)(Math.random() * 4) + 1;

        /*
         * if-else if-else statement
         *  In Java, "else if" is used instead of "elif" like Python.
         */
        if (dieRoll == 1)
        {
            System.out.println("rolled a one");
        }
        else if (dieRoll == 2)
        {
            System.out.println("rolled a two");
        }
        else if (dieRoll == 3)
        {
            System.out.println("rolled a three");
        }
        else
        {
            System.out.println("rolled a four");
        }

        /*
         * { } are not required for a single statement.
         *      However, they are always a good idea.
         *      Leaving them out can lead to bugs like this:
         */
        if (coinFlip == 0)
            System.out.println("Coin is tails!");
        System.out.println("Better luck next time...");
    }

    public static boolean doublesAreEqual(double num1, double num2)
    {
        /*
         * If we use the equality operator (==) for doubles, it will only return true if all
         *      binary digits match.
         *  For "equal" numbers, this is probably not the case due to floating-point rounding and,
         *      therefore, not what we want.
         *  We will check if they are "close enough" (i.e., epsilon  value).
         */

        final double EPSILON = 1e-14;

        if (Math.abs(num1 - num2) < EPSILON)
        {
            return true;
        }
        else
        {
            return false;
        }

        // don't have to use an if statement
        // return Math.abs(num1 - num2) < EPSILON
    }

    public static void stringExample()
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two words: ");
        String str1 = s.next();
        String str2 = s.next();

        /*
         * The equality operator (==) returns true if the two variables (e.g., str1 and str2) contain
         *      the same value. For variables of a class type, including Strings, this means that
         *      they contain the same reference. That is, they refer to the same object in memory,
         *      not that two Strings have the same sequence of characters.
         */
        if(str1 == str2)
        {
            System.out.println("string references are equal");
        }
        else
        {
            System.out.println("string references are not equal");
        }

        /*
         * The equals method returns true if the two objects referenced by the variables are "equal".
         *      What equal means is defined by the class. For Strings, it means that the two objects
         *      have the same sequence of characters.
         */
        if(str1.equals(str2))
        {
            System.out.println("strings are equal");
        }
        else
        {
            System.out.println("strings are not equal");
        }

        /*
         * We will determine which string comes first lexicographically using the compareTo method
         *      of the String class.
         *      
         *  compareTo returns an int:
         *      0:      if the strings are equal (same sequence of characters)
         *      < 0:    if str1 < str2 lexicographically
         *      > 0:    if str1 > str2 lexicographically
         */
        int result = str1.compareTo(str2);

        String firstStr = null;

        if(result < 0)
        {
            firstStr = str1;
        }
        else if(result > 0)
        {
            firstStr = str2;
        }

        if(firstStr != null)
        {
            System.out.println("The first string is: " + firstStr);
            System.out.println("Its length is: " + firstStr.length());
        }
        else
        {
            System.out.println("strings are equal");
        }

        /*
         * This is an example of a "short circuit".
         * 
         *  If the left operand is false, the right operand will not be evaluated because the
         *      AND operation is already false.
         */
        if(firstStr != null && firstStr.length() > 3)
        {
            System.out.println("The first string has more than 3 characters.");
        }

        /*
         * This is another "short circuit" example.
         * 
         *  If the left operand is true, the right operand will not be evaluated because the
         *      OR operations is already true.
         *      
         *  This may result in a bug. If the first word....
         */
        System.out.print("Enter your two favorite fruits: ");
        if(s.next().equals("kiwi") || s.next().equals("kiwi"))
        {
            System.out.println("Kiwi is one of my favorites too!");
        }

        System.out.print("Enter your favorite ice cream flavor: ");
        String flavor = s.next();
        System.out.println("Favorite ice cream flavor: " + flavor);

    }

    public static void extraOperatorsExample()
    {
        /*
         * augmented assignment operators: +=, -=, *=, /=,  %=
         * 
         *  These are the same as in Python.
         *  Perform the specified mathematical operation to the variable and then assign the
         *      resulting value to the same variable.
         */

        int x = 7;
        int y = 7;
        int z = 7;

        x = x + 1;
        y += 1;
        z++;

        System.out.println("x = " + x + "; y = " + y + "; z = " + z);

        /*
         * post increment/decrement operators (++/--)
         * 
         *  These are equivalent to adding/subtracting 1 to/from the variable.
         *  These return the value before performing the increment/decrement.
         */

        int a = 7;
        int b = a++;
        //a++;
        System.out.println("a = " + a + "; b = " + b);  // a = 8; b = 7

        a--; // decrement as well!
        --a; // preincrement operator

        int c = 7;
        int d = ++c;
        System.out.println("c = " + c + "; d = " + d);  // c = 8; d = 8
    }

    
}