package Outils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Jswing {
	public JLabel text(String Text) {
		JLabel textJLabel = new JLabel(Text);
		return textJLabel;
	}
	public JLabel text(String Text, int x, int y, int height, int width) {
		JLabel textJLabel = new JLabel(Text);
		textJLabel.setBounds(x,  y, height, width);
		return textJLabel;
	}
	public JTextField field() {
		JTextField textField = new JTextField();
		return textField;
	}
	public JTextField field(int x, int y, int height, int width) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, height, width);
		return textField;
	}
	public JTextField field(String text, int x, int y, int height, int width) {
		JTextField textField = new JTextField(text);
		textField.setBounds(x, y, height, width);
		return textField;
	}
	public JButton Button(String text) {
		JButton button = new JButton(text);
		return button;
	}
	public JButton Button(String text, int x, int y, int height, int width) {
		JButton button = new JButton(text);
		button.setBounds(x,y,height,width);
		return button;
	}
	
}
