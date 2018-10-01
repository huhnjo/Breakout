package gui;

import general.Parameters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Gameobjects.Ball;
import Gameobjects.Brick;
import Gameobjects.Paddle;
import Listeners.SphereThread;
import Listeners.PaddleListener;

public class PaintingArea extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Brick[] bricks;
	private ImageIcon brickIMG;
	private Paddle paddle;
	private ImageIcon paddleIMG;
	private Ball ball;
	private ImageIcon ballIMG;
	private BufferedImage image;
	private SphereThread kThread;
	private ImageIcon icon;
	

	public PaintingArea(int width, int height){
		this.setSize(width, height);
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));		
		
		this.creategameobjects();
		this.addListener();
		
		icon = new ImageIcon(getClass().getResource("/back.png"));
		image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
        icon.paintIcon(null, image.getGraphics(), 0, 0);
	}
	
	private void addListener(){
		this.addKeyListener(new PaddleListener(paddle, this));
	}
	
	private void creategameobjects(){
		paddleIMG = new ImageIcon(getClass().getResource("/paddle.png"));
		brickIMG = new ImageIcon(getClass().getResource("/brick2.png"));
		ballIMG = new ImageIcon(getClass().getResource("/ball.png"));
		
		this.bricks = new Brick[20];
		for (int i = 0; i < bricks.length; i++) {
			bricks[i] = new Brick(brickIMG);
			bricks[i].setDestroyed(false);
		}
		int y = 20;
		for (int i = 0; i < 5; i++) {
			bricks[i].setPosition(y, 20);
			y += 100;
		}
		
		y = 20;
		for (int i = 5; i < 10; i++) {
			bricks[i].setPosition(y, 60);
			y += 100;
		}

		y = 20;
		for (int i = 10; i < 15; i++) {
			bricks[i].setPosition(y, 100);
			y += 100;
		}
		
		y = 20;
		for (int i = 15; i < 20; i++) {
			bricks[i].setPosition(y, 140);
			y += 100;
		}
		for (int i = 0; i < bricks.length; i++) {
			bricks[i].setWidth(50);
			bricks[i].setHeight(10);
		}
		
		this.paddle = new Paddle(Parameters.BALL_X, Parameters.BALL_Y, paddleIMG);
		this.paddle.setHeight(10);
		this.paddle.setWidth(70);
		ball = new Ball(200, 250, ballIMG);
		ball.setHeight(24);
		ball.setWidth(24);
		kThread = new SphereThread(ball, bricks, paddle, this);
		kThread.begin();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
		g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(), null, null);
		g.setColor(Color.BLACK);
		g.drawImage(ball.getImage(), ball.getX(), ball.getY(), null, null);
		for (int i = 0; i < bricks.length; i++) {
			if(!bricks[i].isDestroyed()){
				g.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), null);
			}
		}
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}	
	
	
	
}
