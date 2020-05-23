import java.awt.Color;
import java.awt.image.BufferedImage;

public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height the height of the desired picture
	 * @param width  the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super();
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void RightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void botToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel bottomleftPixel = null;
		Pixel toprightPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < row; col++) {
				// column will never be greater than row so bottomleftpixel will have [row][col]
				bottomleftPixel = pixels[row][col];
				toprightPixel = pixels[col][row];
				toprightPixel.setColor(bottomleftPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	// same as temple but for rows this time
	public void mirrorArms() {
		int mirrorPoint = 194;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 163; row < mirrorPoint; row++) {
			for (int col = 103; col < 291; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		int mirrorPoint = 342;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 234; row < 321; row++) {
			for (int col = 239; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic  the picture to copy from
	 * @param startRow the start row to copy to
	 * @param startCol the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy2(Picture fromPic, int startRow, int startCol, int endRow, int endCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < endRow; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < endCol; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("src\\images\\flower1.jpg");
		Picture flower2 = new Picture("src\\images\\flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("src\\images\\640x480.jpg");
	}

	public void myCollage() {
		Picture flower1 = new Picture("src\\Images\\flower1.jpg");
		flower1.botToTop();
		Picture flower2 = new Picture("src\\Images\\flower1.jpg");
		flower2.negate();
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flower3 = new Picture("src\\Images\\flower1.jpg");
		flower3.keepOnlyBlue();
		this.copy(flower3, 300, 0);
		this.copy(flower1, 400, 0);
		this.mirrorVertical();
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel mainPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color mainColor = null;
		for (int row = 0; row < pixels.length - 1; row++) {
			for (int col = 0; col < pixels[0].length - 1; col++) {
				mainPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row + 1][col];
				mainColor = mainPixel.getColor();
				if (rightPixel.colorDistance(mainColor) > edgeDist || bottomPixel.colorDistance(mainColor) > edgeDist)
					mainPixel.setColor(Color.BLACK);
				else
					mainPixel.setColor(Color.WHITE);
			}
		}
	}
	
	public void encode(Picture messageImage) {
		Pixel[][] pixels = this.getPixels2D();
		Pixel[][] messagePixels = messageImage.getPixels2D();
		
		Pixel currPixel = null;
		Pixel messagePixel = null;
		
		int count = 0;
		
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				currPixel = pixels[row][col];
				currPixel.setRed(((int) currPixel.getRed() / 10) * 10 + ((int) Math.random() * 4));
				count++;
				messagePixel = messagePixels[row][col];
				if (messagePixel.colorDistance(Color.BLACK) < 50) {
					currPixel.setRed(((int) currPixel.getRed() / 10) * 10 + 4);
				}
			}
		}
		System.out.println(count);
	}

	public void decode() {
		Pixel[][]pixels = this.getPixels2D();
		
		int height = this.getHeight();
		int width = this.getWidth();
		
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				if(pixels[row][col].getRed() == ((int) pixels[row][col].getRed() / 10) * 10 + 4){
					pixels[row][col].setColor(Color.BLACK);
				}
				else {
					pixels[row][col].setColor(Color.WHITE);
				}
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		Picture beach = new Picture("beach.jpg");
		beach.explore();
		beach.zeroBlue();
		beach.explore();
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(0);
				p.setGreen(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setBlue(0);
				p.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(0);
				p.setBlue(0);
			}
		}
	}

	public void fixUnderWater() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setBlue(p.getBlue() - 60);
				p.setGreen(p.getGreen() - 60);
				p.setRed(p.getRed() + 60);
			}
		}
	}

	public void grayScale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				int meanval = (p.getGreen() + p.getRed() + p.getBlue()) / 3;
				p.setRed(meanval);
				p.setBlue(meanval);
				p.setGreen(meanval);
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				p.setRed(255 - p.getRed());
				p.setGreen(255 - p.getGreen());
				p.setBlue(255 - p.getBlue());
			}
		}
	}

}