package Gameobjects;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Brick extends GameObject{

	private int value;
	private boolean destroyed;
	private int width;
	private int height;
	
	public Brick(int x, int y, ImageIcon img, int value) {
		super(x, y, img);
		this.setValue(value);
		this.setDestroyed(false);
	}
	
	public Brick(ImageIcon img){
		super(img);
	}
	
	public Brick(int x, int y, int value) {
		super(x, y);
		this.setValue(value);
		this.setDestroyed(false);
	}
	
	public Rectangle createRectangle(){
		return new Rectangle(this.getPosition(), new Dimension(this.getWidth() , this.getHeight()));		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
