import java.awt.Color;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect.
 *
 * @rpande07 
 * @01/17/21
 */
public class ShepardFairey
{
    private ColorManipulator manipulator;
    private Picture picture;

    private static final Color OFF_WHITE = new Color( 248, 229, 175 );
    private static final Color LIGHT_BLUE = new Color( 121, 149, 159 );
    private static final Color RED = new Color( 198, 50, 45 );
    private static final Color DARK_BLUE = new Color( 16, 48, 77 );

    /**
     * Constructor for ShepardFairey class
     */
    public ShepardFairey( Picture newPicture )
    {
        this.manipulator = new ColorManipulator( newPicture );
        this.picture = newPicture;
    }

    /**
     * Transforms the picture by applying a Shepard Fairey-inspired effect.
     *
     */
    public void transform()
    {
        this.manipulator.grayscale();
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        int greatest = 0;
        int least = 255;

        // finds greatest and least value of grayscale, used red because red, green, and blue are equal
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                int pixelRed = pixel.getRed();
                    
                if (pixelRed > greatest){
                    greatest = pixelRed;
                }
                else if (pixelRed < least){
                    least = pixelRed;
                }
                
            }
        }

        int increments = (greatest-least)/4;
        
        // seperates into 4 sections for 4 different colors
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel(x,y);
                int pixelRed = pixel.getRed();
                    
                if (pixelRed > (3 * increments)){
                    this.manipulator.posterize(OFF_WHITE, x, y);
                }
                else if (pixelRed > (2 * increments)){
                    this.manipulator.posterize(LIGHT_BLUE, x, y);
                }
                else if (pixelRed > increments){
                    this.manipulator.posterize(DARK_BLUE, x, y);
                }
                else{
                    this.manipulator.posterize(RED, x, y);
                }
                
            }

        }

    }
    /**
     * main method for ShepardFairey lab
     */
    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        //  (the selfie image must be in the Shepard Fairey folder)
        Picture selfie = new Picture( "selfiePortrait.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey fairey = new ShepardFairey( selfie );

        // display the original selfie picture
        selfie.explore();

        // transform the selfie picture by applying a Shepard Fairey-inspired effect
        fairey.transform();

        // display the transformed selfie picture
        selfie.explore();

        // save the transformed selfie picture

        /* This code doesn't work for some students for unknown reasons.
         * You may need to specify an absolute path. For example:
         *  finalPic.write("C:\\Users\\gschmit\\GitHub\\decisions-loops-gcschmit\\Shepard Fairey\\MrSchmitPortrait.jpg");
         */
        selfie.write("/home/rpande/conditions-iterations-rpande07/PandePortrait.jpg" );

        // repeat the steps for the selfie in landscape orientation
        selfie = new Picture( "selfieLandscape.jpg" );
        fairey = new ShepardFairey( selfie );
        selfie.explore();
        fairey.transform();
        selfie.explore();
        selfie.write("/home/rpande/conditions-iterations-rpande07/PandeLandscape.jpg" );

        // display the transformed selfie picture again
        selfie.explore();
    }
}