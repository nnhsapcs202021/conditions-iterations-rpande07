

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

/**
 * The test class ColorManipulatorTest.
 *
 * @author  rpande07
 * @version 01/17/21
 */
public class ColorManipulatorTest
{
    /**
     * Default constructor for test class ColorManipulatorTest
     */
    public ColorManipulatorTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * Tests if grayscale method works
     */

    @Test
    public void testGrayScale()
    {
        Picture picture = new Picture( "selfiePortrait.jpg" );
        ColorManipulator manipulator = new ColorManipulator( picture );
        picture.explore();
        Color expectedColor = new Color( 151, 151, 151 );
        manipulator.grayscale();
        Pixel pixel = picture.getPixel(113,328);
        Color actualColor = pixel.getColor();
        assertEquals(expectedColor, actualColor); // compare thet expected pixel's gray value vs. the actual gray value
    }
}
