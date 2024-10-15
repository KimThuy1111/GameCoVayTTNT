package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
	 private Image logo;
	 private JLabel scoreLabel;
	 private JButton newGame,back,role,exit;
	 private BanCo banCo;
	public View() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.HORIZONTAL;
		
		banCo = new BanCo();
		gbc.ipadx=350;
		gbc.ipady=300;
		panel.add(banCo,gbc);
		
		try {
			logo = ImageIO.read(getClass().getResource("LG.png"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridBagLayout());
		Insets buttonInsets = new Insets(12, 0, 0, 0);
        JLabel logoLabel = new JLabel(new ImageIcon(logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        gbc.ipady=10;
        gbc.ipadx=10;
        gbc.insets=buttonInsets;
        bottomPanel.add(logoLabel,gbc);
        newGame = new JButton("Bắt đầu lại");
        gbc.gridy = 1;
        gbc.insets=buttonInsets;
        bottomPanel.add(newGame,gbc);
        back = new JButton("Quay lại");
        gbc.gridy = 2;
        bottomPanel.add(back,gbc);
        role = new JButton("Luật chơi");
        gbc.gridy = 3;
        bottomPanel.add(role,gbc);
        exit = new JButton("Thoát");
        gbc.gridy = 4;
        bottomPanel.add(exit,gbc);
        scoreLabel = new JLabel("Điểm: Đen - 0  Trắng - 0");
		gbc.gridy = 5;
		bottomPanel.add(scoreLabel, gbc);
        
        gbc.gridx=2;
        gbc.gridy=0;
        Dimension panelSize = new Dimension(300,300);
		panel.add(bottomPanel,gbc);
				
		setTitle("GAME CỜ VÂY");
		getContentPane().add(panel);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public  JLabel getScoreLabel() {
		return scoreLabel;
	}
	public void setScoreLabel(JLabel scoreLabel) {
		scoreLabel = scoreLabel;
	}
	public JButton getNewGame() {
		return newGame;
	}
	public void setNewGame(JButton newGame) {
		newGame = newGame;
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		back = back;
	}
	public JButton getRole() {
		return role;
	}
	public void setRole(JButton role) {
		role = role;
	}
	public JButton getExit() {
		return exit;
	}
	public void setExit(JButton exit) {
		exit = exit;
	}
	public BanCo getBanCo() {
		return banCo;
	}

	public void setBanCo(BanCo banCo) {
		this.banCo = banCo;
	}

	public static void main(String[] args) {
		new View();
	}

}