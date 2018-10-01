package Gameobjects;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Paddle extends GameObject{
	
	private int width;
	private int height;

	public Paddle(int x, int y, ImageIcon img) {
		super(x, y, img);
	}
	
	public Rectangle createRectangle(){
		return new Rectangle(this.getPosition(), new Dimension(this.getWidth() , this.getHeight()));		
	}
	
	public Paddle(int x, int y) {
		super(x, y);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
