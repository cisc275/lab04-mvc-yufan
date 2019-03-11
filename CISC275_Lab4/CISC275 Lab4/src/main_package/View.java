/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/
package main_package;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class View extends JPanel{

	private final int width = 500;
	private final int height = 300;
	private final int imageWidth = 165;
	private final int imageHeight = 165;
	int X = 50;
	int Y = 50;
    int picNum = 0;
    BufferedImage[] pics;
    final int frameCount = 10;
    
    JFrame frame;
    
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
	public void update(int X, int Y, Direction direct) {
		
		this.X=X;
		this.Y=Y;
		BufferedImage bufferedImage = null;
		String address = "images/orc/orc_forward_";
		
		switch(direct){
		case SOUTHWEST: 
			address += "southwest.png";
			break;
		case SOUTHEAST:
			address += "southeast.png";
			break;
		case NORTHWEST:
			address += "northwest.png";
			break;
		case NORTHEAST:
			address += "northeast.png";
			break;
		case NORTH:
			address += "north.png";
			break;
		case SOUTH:
			address += "south.png";
			break;
		case EAST:
			address += "east.png";
			break;
		case WEST:
			address += "west.png";
			break;
		}
		
		try {
			bufferedImage = ImageIO.read(new File(address));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		picNum = (picNum + 1) % frameCount;
    	pics = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    	pics[i] = bufferedImage.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
    	
    	frame.repaint();
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		try {

			g.drawImage(pics[picNum], X, Y, Color.gray, this);
		} catch (NullPointerException e) {

		}
	}
	
	public View() {
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(width, height);
    	frame.setVisible(true);
    	
    	BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/orc/orc_forward_southeast.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	pics = new BufferedImage[10];
    	for(int i = 0; i < frameCount; i++)
    		pics[i] = img.getSubimage(imageWidth*i, 0, imageWidth, imageHeight);
	}
}












