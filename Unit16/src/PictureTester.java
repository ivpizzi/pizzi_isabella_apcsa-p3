public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  /** Method to test keepOnlyRed */
  public static void testKeepOnlyRed()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyRed();
    beach.explore();
  }
  /** Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.keepOnlyGreen();
    beach.explore();
  }
  /** Method to test testFixUnderWater */
  public static void testFixUnderwater() {
	  Picture water = new Picture("src\\images\\water.jpg");
	  water.explore();
	  water.fixUnderWater();
	  water.explore();
  }
  /** Method to test testGrayScale */
  public static void testGrayscale()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }
  /** Method to test testNegate */
  public static void testNegate()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("src\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testRightToLeft()
  {
    Picture redCycle = new Picture("src\\images\\redMotorcycle.jpg");
    redCycle.explore();
    redCycle.RightToLeft();
    redCycle.explore();
  }
  
  public static void testBotToTop()
  {
    Picture redCycle = new Picture("src\\images\\redMotorcycle.jpg");
    redCycle.explore();
    redCycle.botToTop();
    redCycle.explore();
  }
  public static void testMirrorDiagnol()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("src\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("src\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  /** Method to test mirrorArms*/
  public static void testMirrorArms() {
	  Picture snowman = new Picture("src\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  /** Method to test mirrorGull*/
  public static void testMirrorGull() {
	  Picture gull = new Picture("src\\images\\seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("src\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  public static void testMyCollage() {
	  	Picture canvas = new Picture("src\\Images\\640x480.jpg");
	    canvas.myCollage();
	    canvas.explore();
}
  public static void testCopy(){
	  Picture copy =new Picture("src\\images\\640x480.jpg");
	  Picture copied = new Picture("src\\images\\snowman.jpg");
	  copy.explore();
	  copy.copy(copied, 72, 120);
	  copy.explore();
  }
  public static void testCopy2(){
	  Picture copy =new Picture("src\\images\\640x480.jpg");
	  Picture copied = new Picture("src\\images\\snowman.jpg");
	  copy.explore();
	  copy.copy2(copied, 200, 300, 400, 500);
	  copy.explore();
  }
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("src\\images\\swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testEncodeDecode()
  {
    Picture beach = new Picture("src\\images\\beach.jpg");
    Picture apple = new Picture("src\\images\\apple2.png");
    Picture msg = new Picture("src\\images\\msg.jpg");
    beach.explore();
    beach.encode(apple);
    beach.explore();
    beach.decode();
    beach.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue(); 	
    //testKeepOnlyBlue();	
    //testKeepOnlyRed();	
    //testKeepOnlyGreen();	
    //testNegate();		
    //testGrayscale();	
    //testFixUnderwater();	
    //testMirrorVertical(); 
	//testRightToLeft();	
	//testMirrorHorizontal(); 
	//testBotToTop();
	//testMirrorDiagnol();
    //testMirrorTemple();
	//testMirrorArms();
    //testMirrorGull();
    //testCollage();
	//testMyCollage();
    //testCopy();
	//testCopy2();
    //testEdgeDetection();
	  testEncodeDecode();
    
    //DON'T GO PAST THIS POINT
    
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}