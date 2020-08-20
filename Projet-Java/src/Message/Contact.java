package Message;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Outils.JswingCF;

public class Contact extends JFrame {
	JPanel contentPane =  (JPanel) this.getContentPane();
	private static final long serialVersionUID = -185689405427665652L;
	int MousepX;
	int MousepY;
	JswingCF outils = new JswingCF();

	public Contact () {
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(370,200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		
		contentPane.add(ErreurCompte());
		
		
	}
	
	private JPanel ErreurCompte() {
		JPanel centralJPanel = new JPanel();
		
		// Header noir
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51,51,51));
		panel.setBounds(0, 0, 373, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				MousepX=arg0.getX();
				MousepY=arg0.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int xCord = arg0.getXOnScreen();
				int yCord = arg0.getYOnScreen();
				setLocation(xCord-MousepX, yCord-MousepY);
			}
		});
		
		
		// close bouton
		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("src/images/close.png"));
		closeButton.setBounds(330,0,40,40);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.setBackground(new Color(51,51,51));;
		closeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
			public void mouseEntered(MouseEvent arg0) {
				closeButton.setBackground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				closeButton.setBackground(new Color(51,51,51));
			}
		});
		panel.add(closeButton);
		

		// Boutton -
		JButton reduiButton = new JButton();
		reduiButton.setIcon(new ImageIcon("src/images/reduire.png"));
		reduiButton.setBounds(290, 0, 40, 40);
		reduiButton.setBackground(new Color(51,51,51));
		reduiButton.setBorderPainted(false);
		reduiButton.setFocusPainted(false);
		reduiButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {
				reduiButton.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent arg0) {
				reduiButton.setBackground(new Color(51,51,51));
			}
		});
		panel.add(reduiButton);
		
		// background corps
		centralJPanel.setBounds(0, 40, 373, 175);
		centralJPanel.setBackground(new Color(44,62,80));
		getContentPane().add(centralJPanel);
		centralJPanel.setLayout(null);
		
		// message 
		centralJPanel.add(outils.textCF(255, 255, 255, "email: ", 60, 20, 190, 30, 20));
		centralJPanel.add(outils.textCF(255, 255, 255, "example.mail@voila.fr ", 160, 20, 250, 30, 20));
		centralJPanel.add(outils.textCF(255, 255, 255, "telephone: ", 60, 50, 190, 30, 20));
		centralJPanel.add(outils.textCF(255, 255, 255, "01.01.01.01.01 ", 160, 50, 250, 30, 20));
		
		// Boutton ok
		JButton OKBoutton = new JButton("OK");
		OKBoutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		OKBoutton.setBackground(Color.WHITE);
		OKBoutton.setBounds(155, 100, 60, 20);
		centralJPanel.add(OKBoutton);
		return centralJPanel;
	}
}