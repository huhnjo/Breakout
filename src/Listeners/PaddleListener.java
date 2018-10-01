package Listeners;

import general.Parameters;
import gui.PaintingArea;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Gameobjects.Paddle;

public class PaddleListener implements KeyListener{
	
	private Paddle paddle;
	private PaintingArea mb;
	
	public PaddleListener(Paddle paddle, PaintingArea mb) {
		this.paddle = paddle;
		this.mb = mb;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(paddle.getX() >= 0){
				this.moveLeft();
			}
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(paddle.getX() <= Parameters.WIDTH_MALBEREICH - paddle.getWidth()){
				this.moveRight();
			}
		}
	}
	
	private void moveLeft(){
		paddle.setPosition(paddle.getX()-8, paddle.getY());
		mb.revalidate();
		mb.repaint();
	}
	
	private void moveRight(){
		paddle.setPosition(paddle.getX()+8, paddle.getY());
		mb.revalidate();
		mb.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
