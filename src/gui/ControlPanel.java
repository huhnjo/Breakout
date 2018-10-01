package gui;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JButton neustart;
	private JButton beenden;
	private MainGui mg;
	
	public ControlPanel(int width, int height, MainGui mg){
		this.setLayout(new FlowLayout());	
		this.setSize(width, height);
		this.createButtons();
		this.add(neustart);
		this.add(beenden);
		this.mg = mg;
	}
	
	private void createButtons(){
		this.neustart = new JButton("Neustart");
		neustart.setBackground(Color.GREEN);
		neustart.addActionListener(this);
		this.beenden = new JButton("Exit");
		beenden.setBackground(Color.RED);
		beenden.addActionListener(this);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN,3));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == neustart){
			mg.dispose();
			new MainGui();
		}else{
			System.exit(0);
		}
	}
}
