package Listeners;

import general.Parameters;
import gui.PaintingArea;

import java.awt.Point;
import java.awt.Rectangle;

import Gameobjects.Ball;
import Gameobjects.Brick;
import Gameobjects.Paddle;

public class SphereThread implements Runnable{

	private boolean enabled;
	
	private Ball ball;
	private Brick[] bricks;
	private Paddle paddle;
	private PaintingArea mb;
	
	public SphereThread(Ball ball, Brick[] bricks, Paddle paddle, PaintingArea mb){
		this.ball = ball;
		this.bricks = bricks;
		this.paddle = paddle;
		this.mb = mb;
	}
	
	public void begin(){
		enabled = true;
		new Thread(this).start();
	}
	
	public void kill(){
		this.enabled = false;
	}
	
	private void testCollision(){
		int counter = 0;
		for (int i = 0; i < bricks.length; i++) {
			if(counter == 10){
				Parameters.SLEEP -= 3;
			}else if(counter == 15){
				Parameters.SLEEP -= 3;
			}
			
			counter = 0;
			if(bricks[i].isDestroyed()){
				counter++;
				continue;
			}
			Rectangle brickRec = bricks[i].createRectangle();
			//BallPunkt #Raute
			Point top = new Point(ball.getX() + ball.getWidth()/2, ball.getY());
			Point bottom = new Point(ball.getX() + ball.getWidth()/2 , ball.getY() + ball.getHeight());
			Point left = new Point(ball.getX(), ball.getY() + ball.getHeight()/2);
			Point right = new Point(ball.getX() + ball.getWidth() , ball.getY() + ball.getHeight()/2);
			
			if(brickRec.contains(top)){
				bricks[i].setDestroyed(true);
				ball.invertyDir();
			}else if(brickRec.contains(bottom)){
				bricks[i].setDestroyed(true);
				ball.invertyDir();
			}else if(brickRec.contains(left)){
				bricks[i].setDestroyed(true);
				ball.invertxDir();
			}else if(brickRec.contains(right)){
				bricks[i].setDestroyed(true);
				ball.invertxDir();
			}
			
		}
	}
	
	private void testPaddleCollision(){
		Rectangle paddRec = paddle.createRectangle();
		Rectangle ballRec = ball.createRectangle();
		if(paddRec.intersects(ballRec)){
			ball.paddleHit();			
		}
	}
	
	private void moveBall(){
		ball.move();
		mb.repaint();
	}
	
	private void testendgame(){
		if(ball.getY()+ball.getHeight() >= Parameters.HEIGHT_MALBEREICH){
			System.exit(0);
		}
		for (int i = 0; i < bricks.length; i++) {
			if(!bricks[i].isDestroyed()){
				return;
			}
		}
		System.exit(0);
	}
	
	@Override
	public void run() {
		ball.setxDirection(-1);
		ball.setyDirection(-1);
		while(enabled){
			this.moveBall();
			this.testPaddleCollision();
			this.testCollision();
			this.testendgame();
			try {
				Thread.sleep(Parameters.SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
