package Outils;

import java.awt.Font;

import javax.swing.JLabel;

public class JswingCF extends JswingColor{
	public JLabel textCF(int c1, int c2, int c3, String text, int x, int y, int height, int width, int taille) {
		JLabel textLabel = color(c1, c2, c3, text, x, y, height, width);
		textLabel.setFont(new Font("Tahoma", Font.PLAIN, taille));
		return textLabel;
	}
	public JLabel textCF(int c1, int c2, int c3, String text, int taille) {
		JLabel texLabel = text(c1, c2, c3, text);
		texLabel.setFont(new Font("Tahoma", Font.PLAIN, taille));
		return texLabel;
	}
	public JLabel textCF(String text, int taille) {
		JLabel texLabel = text(text);
		texLabel.setFont(new Font("Tahoma", Font.PLAIN, taille));
		return texLabel;
	}
	public JLabel textCF(String text, int x, int y, int height, int width, int taille) {
		JLabel texLabel = text(text, x, y, height, width);
		texLabel.setFont(new Font("Tahoma", Font.PLAIN, taille));
		return texLabel;
	}

}
