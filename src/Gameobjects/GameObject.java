package Gameobjects;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class GameObject {
	
	protected int x;
	protected int y;
	protected Point position;
	protected ImageIcon img;
	
	public GameObject(int x, int y, ImageIcon img){
		this.x = x;
		this.y = y;
		this.position = new Point(x, y);
		this.img = img;
	}
	
	public GameObject(ImageIcon img){
		this.img = img;
	}
	
	public GameObject(int x, int y){
		this.x = x;
		this.y = y;
		this.position = new Point(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Point getPosition() {
		return new Point(this.x,this.y);
	}

	public void setPosition(Point position) {
		this.position = position;
		this.x = (int) position.getX();
		this.y = (int) position.getY();
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		this.position = new Point(x, y);
	}

	public ImageIcon getImg() {
		return img;
	}
	
	public Image getImage(){
        BufferedImage image = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        img.paintIcon(null, image.getGraphics(), 0, 0);
        return image;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}


	
	
	
}
