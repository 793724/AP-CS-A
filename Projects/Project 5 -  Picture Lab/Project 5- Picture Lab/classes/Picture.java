import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.util.Random; // for edge detection with color

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    // Method to set the green to zero
    public void zeroGreen()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
            }
        }
    }

    // Method to set the red to zero
    public void zeroRed()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
            }
        }
    }

    /** Method to set the red and green to 0 */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Method to set the blue and green to 0 */
    public void keepOnlyRed()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Method to set the red and blue to 0 */
    public void keepOnlyGreen()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setBlue(0);
            }
        }
    }

    /** Method to negate all color values */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /** Method to turn the picture into shades of gray */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    /** Method to make the picture's fish easier to see */
    public void fixUnderwater()
    {
        // instance variables
        Pixel currentPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        int currentRed = 0;
        int currentGreen = 0;
        int currentBlue = 0;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++)
            {
                currentPixel = pixels[row][col];
                currentRed = currentPixel.getRed();
                currentGreen = currentPixel.getGreen();
                currentBlue = currentPixel.getBlue();
                // making colors stand out more
                currentPixel.setRed(currentRed+50);
                currentPixel.setBlue(currentBlue/2+50);
                currentPixel.setGreen(currentGreen-85);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from top to bottom */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * horizontal mirror in the center of the picture
     * from bottom to top */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        } 
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    /** Make a snowman with four arms */
    public void mirrorArms()
    {
        int mirrorPoint = 195;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // split into left arm and right arm to avoid mirroring body

        // left arm: loop through the rows
        for (int col = 102; col < 170; col++)
        {
            // loop from 155 to just before the mirror point
            for (int row = 155; row < mirrorPoint; row++)
            {

                topPixel = pixels[row][col];      
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }

        // right arm: loop through the rows
        for (int col = 238; col < 293; col++)
        {
            // loop from 170 to just before the mirror point
            for (int row = 170; row < mirrorPoint; row++)
            {

                topPixel = pixels[row][col];      
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** Mirror a seagull */
    public void mirrorGull()
    {
        int mirrorPoint = 344;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 235; row < 330; row++)
        {
            // loop from 235 to just before the mirror point
            for (int col = 235; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Method that mirrors the picture around a 
     * diagonal mirror in the center of the picture
     * from bottom left to top right */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel firstPixel = null;
        Pixel copiedPixel = null;
        int height = pixels.length;
        int width = pixels[0].length;
        for (int row = 0; row < height; row++)
        {
            for (int col = 0; col < height; col++)
            {
                firstPixel = pixels[row][col];
                copiedPixel = pixels[col][row];
                firstPixel.setColor(copiedPixel.getColor());
            }
        } 
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copyTwo(Picture fromPic, 
    int startRow, int endRow,
    int startCol, int endCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < endRow; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < endCol;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
        fromRow < fromPixels.length &&
        toRow < toPixels.length; 
        fromRow++, toRow++)
        {
            for (int fromCol = 0, toCol = startCol; 
            fromCol < fromPixels[0].length &&
            toCol < toPixels[0].length;  
            fromCol++, toCol++)
            {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }   
    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to create a collage using the second copy method */
    public void createCollageTwo()
    {
        // the two pictures
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        // uses the copy two method to copy part of each picture
        this.copyTwo(flower1,0,50,0,50);
        this.copyTwo(flower2,100,150,0,50);
        this.copyTwo(flower1,200,250,0,50);
        // makes a new flower without blue
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        // copies the new flower
        this.copyTwo(flowerNoBlue,300,350,0,50);
        this.copyTwo(flower1,400,450,0,50);
        this.copy(flower2,500,0);
        // flips the collage over the y-axis
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to create a collage of multiple pictures */
    public void myCollage()
    {
        // normal zinnia (NB: may not actually be a zinnia)
        Picture zinnia = new Picture("smallZinnia.jpg");
        this.copy(zinnia, 32, 10);
        // blue zinnia
        Picture zinniaBlue = new Picture(zinnia);
        zinniaBlue.zeroBlue();
        this.copy(zinniaBlue, 32, 167);
        // green zinnia
        Picture zinniaGreen = new Picture(zinnia);
        zinniaGreen.zeroGreen();
        this.copy(zinniaGreen, 137, 10);
        // red zinnia
        Picture zinniaRed = new Picture(zinnia);
        zinniaRed.zeroRed();
        this.copy(zinniaRed, 137, 167);
        // mirrors the collage twice
        this.mirrorVertical();
        this.mirrorHorizontal();
        this.write("myCollage.jpg");
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     * 
     * Added loop to account for top and bottom
     */
    public void edgeDetection(int edgeDist) {
        // instance variables
        Pixel currentPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel diagPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        Color bottomColor = null;
        Color diagColor = null;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++)
            {
                currentPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                diagPixel = pixels[row+1][col+1];
                rightColor = rightPixel.getColor();
                bottomPixel = pixels[row+1][col];
                bottomColor = bottomPixel.getColor();
                diagColor = diagPixel.getColor();
                // compares current pixel to the one to the right of it, the one beneath it, and the one diagonal from it
                if (currentPixel.colorDistance(rightColor) > edgeDist
                || currentPixel.colorDistance(bottomColor) > edgeDist
                || currentPixel.colorDistance(diagColor) > edgeDist) {
                    // if there's an edge
                    currentPixel.setColor(Color.BLACK);
                }
                else {
                    // no edge
                    currentPixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
    /** 
     * A second method for edge detection (self-created)
     */
    public void edgeDetection2() {
        // instance variables
        Pixel currentPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel diagPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        Color bottomColor = null;
        Color diagColor = null;
        int currentAverage = 0;
        int rightAverage = 0;
        int bottomAverage = 0;
        int diagAverage = 0;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++)
            {
                currentPixel = pixels[row][col];
                currentAverage = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue())/3;
                rightPixel = pixels[row][col+1];
                rightAverage = (rightPixel.getRed() + rightPixel.getGreen() + rightPixel.getBlue())/3;
                bottomPixel = pixels[row+1][col];
                bottomAverage = (bottomPixel.getRed() + bottomPixel.getGreen() + bottomPixel.getBlue())/3;
                diagPixel = pixels[row+1][col+1];
                diagAverage = (diagPixel.getRed() + diagPixel.getGreen() + diagPixel.getBlue())/3;
                // compares current pixel to the one to the right of it and the one beneath it
                if (currentAverage > rightAverage + 4
                || currentAverage > bottomAverage + 4
                || currentAverage > diagAverage + 4) {
                    // if there's an edge
                    currentPixel.setColor(Color.BLACK);
                }
                else {
                    // no edge
                    currentPixel.setColor(Color.WHITE);
                }
            }
        }
    }

    /** 
     * Edge detection (original method) with added loop and in color
     */
    public void edgeDetectionColor(int edgeDist) {
        // instance variables
        Pixel currentPixel = null;
        Pixel rightPixel = null;
        Pixel bottomPixel = null;
        Pixel diagPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        Color bottomColor = null;
        Color diagColor = null;
        for (int row = 0; row < pixels.length - 1; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++)
            {
                currentPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                diagPixel = pixels[row+1][col+1];
                rightColor = rightPixel.getColor();
                bottomPixel = pixels[row+1][col];
                bottomColor = bottomPixel.getColor();
                diagColor = diagPixel.getColor();
                // compares current pixel to the one to the right of it, the one beneath it, and the one diagonal from it
                if (currentPixel.colorDistance(rightColor) > edgeDist
                || currentPixel.colorDistance(bottomColor) > edgeDist
                || currentPixel.colorDistance(diagColor) > edgeDist) {
                    // if there's an edge
                    int x = (int)(Math.random()*255);
                    int y = (int)(Math.random()*255);
                    int z = (int)(Math.random()*255);
                    Color color = new Color (x, y, z);
                    currentPixel.setColor(color);
                }
                else {
                    // no edge
                    currentPixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
        /** Main method for testing - each class in Java can have a main 
         * method 
         */
        public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
