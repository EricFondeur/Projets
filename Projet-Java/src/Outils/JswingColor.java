package Outils;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JswingColor extends Jswing{
	public JLabel color(int c1, int c2, int c3, String text, int x, int y, int height, int width) {
		JLabel textLabel = text(text, x, y, height, width);
		textLabel.setForeground(new Color(c1,c2,c3));
		return textLabel;
	}
	public JLabel text(int c1, int c2, int c3, String text) {
		JLabel textLabel = text(text);
		textLabel.setForeground(new Color(c1,c2,c3));
		return textLabel;
	}
	public JButton buttonBF(String nom, int r, int g, int b) {
		JButton tempButton = new JButton(nom);
		tempButton.setBackground(new Color(r,g,b));
		tempButton.setBorderPainted(false);
		tempButton.setFocusPainted(false);
		return tempButton;
	}
	
	public JButton ButtonBF(String text, int c1, int c2, int c3) {
		JButton button = Button(text);
		button.setForeground(new Color(c1,c2,c3));
		return button;
	}
	public JButton ButtonBF(int c1, int c2, int c3, String text, int x, int y, int height, int width) {
		JButton button = Button(text, x, y, height, width);
		button.setForeground(new Color(c1,c2,c3));
		return button;
	}
}
