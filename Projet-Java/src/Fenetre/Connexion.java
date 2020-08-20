package Fenetre;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Outils.JswingCF;
import SQL.Select;

public class Connexion extends JFrame {
	private static final long serialVersionUID = 1L;

	Select select=new Select();
	JPanel contentPane =  (JPanel) this.getContentPane();
	JswingCF outils = new JswingCF();
	private JTextField IDText;
	private JPasswordField MDPField;
	int MousepX;
	int MousepY;
	static String idsString;
	String mdpString;
	String nomString;
	String prenomString;
	public Connexion() {
		/* construction de l'interface graphique*/
		super( "Ma premier application swing" );
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		
		contentPane.add(ConnexionFenetre());
		
	}
	
	
	private JPanel ConnexionFenetre() {
		
		//jpanel head debut
				JPanel panel = new JPanel();
				panel.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent arg0) {
						MousepX=arg0.getX();
						MousepY=arg0.getY();
					}
				});
				panel.addMouseMotionListener(new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent arg0) {
						int xCord = arg0.getXOnScreen();
						int yCord = arg0.getYOnScreen();
						setLocation(xCord-MousepX, yCord-MousepY);
					}
				});
				panel.setBackground(new Color(51, 51, 51));
				panel.setBounds(0, 0, 400, 40);
				getContentPane().add(panel);
				panel.setLayout(null);
				
				// Titre Connexion
				panel.add(outils.textCF(255, 255, 255, "Connexion", 45, 0, 130, 40, 22));
				
				// close bouton
				JButton closeButton = new JButton();
				closeButton.setIcon(new ImageIcon("src/images/close.png"));
				closeButton.setBounds(360,0,40,40);
				closeButton.setFocusPainted(false);
				closeButton.setBorderPainted(false);
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
				reduiButton.setBounds(320, 0, 40, 40);
				reduiButton.setBackground(new Color(51,51,51));
				reduiButton.setFocusPainted(false);
				reduiButton.setBorderPainted(false);
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
				//jpanel header fin
				
				//Jpanel corps debut
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(44,62,80));
				panel_1.setBounds(0, 40, 400, 260);
				getContentPane().add(panel_1);
				panel_1.setLayout(null);
				
				// text identifiant
				
				
				panel_1.add(outils.textCF(255, 255, 255, "Identifiant:", 60, 50, 100, 25, 19));
				IDText = outils.field(170, 50, 160, 25);
				panel_1.add(IDText);				
				//JTextField IDText = outils.field(170, 50, 160, 25);
				//panel_1.add(IDText);
				
				// text mot de passe
				
				panel_1.add(outils.textCF(255, 255, 255, "Mot de passe:", 35, 90, 120, 25, 19));
				
				// Boutton Connexion
				// Test base de donnée
				JButton ConnexionBouton = new JButton("Connexion");
				ConnexionBouton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						login();
						dispose();
					}
				});
				
				// Bakcground boutton connexion
				ConnexionBouton.setForeground(new Color(255, 255, 255));
				ConnexionBouton.setBackground(new Color(51, 51, 51));
				ConnexionBouton.setBounds(235, 140, 95, 35);
				panel_1.add(ConnexionBouton);
				
				// clique entrer 
				MDPField = new JPasswordField();
				MDPField.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent arg0) {
						if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
							login();
							dispose();
						}
					}
				});
				MDPField.setBounds(170, 90, 160, 25);
				panel_1.add(MDPField);
				
				// Boutton annuler
				JButton AnnulerBouton = new JButton("Annuler");
				AnnulerBouton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
					}
				});
				AnnulerBouton.setBackground(new Color(51, 51, 51));
				AnnulerBouton.setForeground(new Color(255, 255, 255));
				AnnulerBouton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				AnnulerBouton.setBounds(133, 140, 90, 35);
				panel_1.add(AnnulerBouton);
				
				// text aucun compte
				panel_1.add(outils.textCF(255,255,255,"Pas de compte ?", 140, 200, 115, 15, 15));
				
				// passage a la page inscription 
				JLabel InscriptionLabel = outils.textCF(255, 255, 255, "Inscription", 260, 200, 70, 15, 15);
				InscriptionLabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						dispose();
						Inscription inscription = new Inscription();
						inscription.setVisible(true);
						inscription.setLocationRelativeTo(null);
						inscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				});
				panel_1.add(InscriptionLabel);
				return panel;
				//jpanel corps fin
	}
	
	public static void main (String[] argc) {
		Connexion maConnexion = new Connexion();
		
		maConnexion.setVisible(true);
	}
	
	private void login() {
		idsString = IDText.getText();
		mdpString = String.valueOf(MDPField.getPassword());
		select.Connexion(idsString, mdpString);
	}
	
	public String getId() {
		return idsString;
	}
	
	public String getNom() {
		return nomString;
	}
	public String getPrenom() {
		return prenomString;
	}
}
