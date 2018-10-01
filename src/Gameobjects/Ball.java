package Gameobjects;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import general.Parameters;

import javax.swing.ImageIcon;

public class Ball extends GameObject{
	
	private int radius;
	private int width;
	private int height;
	private int xDirection;
	private int yDirection;

	public Ball(int x, int y, ImageIcon img) {
		super(x, y, img);
	}

	public Ball(int x, int y) {
		super(x, y);
	}
	
	public void move(){
		this.x += xDirection;
		this.y += yDirection;
		if(x == 0) {
			xDirection = 1;
		}
		if(x == Parameters.WIDTH_MALBEREICH - Parameters.BALL_WIDTH) {
			xDirection = -1;
		}
		if(y == 0) {
			yDirection = 1;
		}
		if(y == Parameters.HEIGHT_MALBEREICH){
			yDirection = -1;
		}
	}
	
	public void paddleHit(){
		yDirection = -1;
	}
	
	public void invertxDir(){
		xDirection = xDirection * (-1);
	}
	
	public void invertyDir(){
		yDirection = yDirection * (-1);
	}
	
	public Rectangle createRectangle(){
		return new Rectangle(new Point(this.getX(), this.getY()), new Dimension(this.getWidth() , this.getHeight()));		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
	
	
	
}
