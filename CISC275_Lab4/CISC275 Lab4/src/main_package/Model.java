/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
package main_package;
class Model{
	
	private int width;
	private int height;
	private int imageWidth;
	private int imageHeight;
	private int X = 50;
	private int Y = 50;
	private Direction Direct = Direction.SOUTHEAST;
	private static int xIncr = 8;
	private static int yIncr = 8;
	
	
	public Model(int width, int height, int imageWidth, int imageHeight) {
		this.width = width;
		this.height = height;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public Direction getDirect() {
		return Direct;
	}

	public static int getxIncr() {
		return xIncr;
	}

	public static int getyIncr() {
		return yIncr;
	}
	
	public void updateLocationAndDirection() {
		
    	boolean flag = false;
    	
    	if (X<=0 || X>=width-imageWidth) {
    		xIncr *= -1;
    		flag = true;
    	}    	
    	
    	if (Y<=0 || Y>=height-imageHeight) {
    		yIncr *= -1;
    		flag = true;
    	}
    	
    	X+=xIncr;
    	Y+=yIncr;
    	
    	if (flag) {
    		if (xIncr > 0) {
    			if (yIncr > 0)
    				Direct = Direction.SOUTHEAST;
    			if (yIncr < 0)
    				Direct = Direction.NORTHEAST;
    		}
    		else {
    			if (yIncr > 0)
    				Direct = Direction.SOUTHWEST;
    			if (yIncr < 0)
    				Direct = Direction.NORTHWEST;
    		}
    	}
    	
	}
	
}