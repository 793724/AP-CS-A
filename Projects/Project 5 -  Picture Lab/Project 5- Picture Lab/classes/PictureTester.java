/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.zeroBlue();
    stickers.explore();
  }
  
  // Method to test zeroGreen
  public static void testZeroGreen()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.zeroGreen();
    stickers.explore();
  }
  
  // Method to test zeroRed
  public static void testZeroRed()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.zeroRed();
    stickers.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.keepOnlyBlue();
    stickers.explore();
  }
  
  /** Method to test keepOnlyRed */
  public static void testKeepOnlyRed()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.keepOnlyRed();
    stickers.explore();
  }
  
  /** Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen()
  {
    Picture stickers = new Picture("smallStickers.jpg");
    stickers.explore();
    stickers.keepOnlyGreen();
    stickers.explore();
  }
  
  /** Method to test negate */
  public static void testNegate()
  {
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.negate();
    belvedere.explore();
  }
  
  /** Method to test grayscale */
  public static void testGrayscale()
  {
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.grayscale();
    belvedere.explore();
  }
  
  /** Method to test fixUnderwater */
  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  
  /** Method to test mirrorVertical (added own picture) */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
    
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.mirrorVertical();
    belvedere.explore();
  }
  
  /** Method to test mirrorVerticalRightToLeft (added own picture) */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
    
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.mirrorVerticalRightToLeft();
    belvedere.explore();
  }
  
  /** Method to test mirrorHorizontal (added own picture) */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
    
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.mirrorHorizontal();
    belvedere.explore();
  }
  
  /** Method to test mirrorHorizontalBotToTop (added own picture) */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
    
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.mirrorHorizontalBotToTop();
    belvedere.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test mirrorArms */
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  
  /** Method to test mirrorGull */
  public static void testMirrorGull()
  {
    Picture seagull = new Picture("seagull.jpg");
    seagull.explore();
    seagull.mirrorGull();
    seagull.explore();
  }
  
  /** Method to test mirrorDiagonal (added own picture) */
  public static void testMirrorDiagonal()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
    
    Picture belvedere = new Picture("smallBelvedere.jpg");
    belvedere.explore();
    belvedere.mirrorDiagonal();
    belvedere.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test the createCollageTwo method */
  public static void testCollageTwo()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollageTwo();
    canvas.explore();
  }
  
  /** Method to test the myCollage method */
  public static void testMyCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test edgeDetection2 */
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2();
    swan.explore();
  }
  
  /** Method to test edgeDetectionColor */
  public static void testEdgeDetectionColor()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetectionColor(10);
    swan.explore();
  }
  
  /** Method to test edgeDetectionColor using my picture */
  public static void testEdgeDetectionColorMyPic()
  {
    Picture me = new Picture("EmmaPic.jpg");
    me.explore();
    me.edgeDetectionColor(20);
    me.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testZeroGreen();
    //testZeroRed();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testCollageTwo();
    //testMyCollage();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testEdgeDetectionColor();
    testEdgeDetectionColorMyPic();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}