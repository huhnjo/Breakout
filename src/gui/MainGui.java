package gui;

import general.Parameters;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Listeners.PaddleListener;

public class MainGui extends JFrame{

	private static final long serialVersionUID = 1L;
	private Container c;
	private ControlPanel cp;
	private PaintingArea mb;
	private JLabel imagelabel;
	
	public MainGui(){
		this.init();
		this.createComponents();	
	}
	
	private void init(){
		c = this.getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
		this.setTitle("Breakout");
		this.setVisible(true);
		this.setSize(Parameters.WIDTH_CONTROL +16 , Parameters.HEIGHT_MALBEREICH + Parameters.HEIGHT_CONTROL);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		imagelabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("/back.png"));
		imagelabel.setIcon(icon);
	}
	
	private void createComponents(){
		cp = new ControlPanel(Parameters.WIDTH_CONTROL, Parameters.HEIGHT_CONTROL,this);
		c.add(cp);
		
		
		mb = new PaintingArea(Parameters.WIDTH_MALBEREICH, Parameters.HEIGHT_MALBEREICH);
		Container d = new Container();
		d.add(mb);
		d.setPreferredSize(new Dimension(Parameters.WIDTH_MALBEREICH, Parameters.HEIGHT_MALBEREICH));
		c.add(d);
		this.addKeyListener(new PaddleListener(mb.getPaddle(), mb));
		this.revalidate();
		this.repaint();
		this.pack();
	}
}
