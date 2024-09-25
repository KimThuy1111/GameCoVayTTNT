package covay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	
	public View() {
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		
		Board broad = new Board();
		broad.setPreferredSize(new Dimension(500,500));
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER,0,0);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(flow);
		

		panel.add(broad);
		panel.add(bottomPanel);
		
		
		
		setTitle("GAME CỜ VÂY");
		getContentPane().add(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new View();
	}

}
