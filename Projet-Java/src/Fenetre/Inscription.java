package Fenetre;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Outils.Jswing;
import SQL.Insert;

public class Inscription extends JFrame{

	Insert insert = new Insert();
	private static final long serialVersionUID = 1L;
	JPanel contentPane =  (JPanel) this.getContentPane();
	private JTextField NomText;
	private JTextField PrenomText;
	private JTextField IDText;
	private JPasswordField MDPField;
	private JPasswordField VMDPField;
	private JDateChooser DateNaissChooser;
	private JTextField email;
	String roleString = "utilisateur";
	int MousepX;
	int MousepY;
	Jswing outils = new Jswing();
	
	JRadioButton hommeButton = new JRadioButton("homme");
	JRadioButton femmeButton = new JRadioButton("femme");

	String genre="";
	
	public Inscription () {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		
		//contentPane.add(InscriptionFentre());
		contentPane.add(inscriptPageJPanel());
		
	}
	
	public JPanel inscriptPageJPanel () {
		
		// Header bakcground
		getContentPane().setLayout(null);
		JPanel panelHead = new JPanel();
		panelHead.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				MousepX=arg0.getX();
				MousepY=arg0.getY();
			}
		});
		panelHead.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent arg0) {
				int xCord = arg0.getXOnScreen();
				int yCord = arg0.getYOnScreen();
				setLocation(xCord-MousepX, yCord-MousepY);
			}
		});
		panelHead.setBackground(new Color(51, 51, 51));
		panelHead.setBounds(0, 0, 500, 40);
		getContentPane().add(panelHead);
		panelHead.setLayout(null);
		
		
		// text indcription
		JLabel lblInscription = outils.text("Inscription", 45, 0, 130, 40);
		lblInscription.setForeground(new Color(255, 255, 255));
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panelHead.add(lblInscription);
		
		// close bouton
		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("src/images/close.png"));
		closeButton.setBounds(460,0,40,40);
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
		panelHead.add(closeButton);
		

		// Boutton -
		JButton reduiButton = new JButton();
		reduiButton.setIcon(new ImageIcon("src/images/reduire.png"));
		reduiButton.setBounds(420, 0, 40, 40);
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
		panelHead.add(reduiButton);
		
		// Background corps
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 40, 500, 660);
		getContentPane().add(panel);
	
		// Boutton inscription
		// Insertion dans la base de donnée
		JButton InscriptionBoutton = new JButton("Inscription");
		InscriptionBoutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (hommeButton.isSelected()){
					genre="homme";
				}
				else if (femmeButton.isSelected()) {
					genre = "femme";
				}
				
				String nomsString = NomText.getText();
				String prenomString = PrenomText.getText();
				String idsString = IDText.getText();
				String mdpString = String.valueOf(MDPField.getPassword());
				String vmdpString = String.valueOf(VMDPField.getPassword());
				String dateString = null;
				String emailString = email.getText();
				
				if (idsString.equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter un Identifiant");
				}
				else if (mdpString.equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter un mot de passe");
				}
				else if (!mdpString.equals(vmdpString)) {
					JOptionPane.showMessageDialog(null, "La vérification du mot de passe est incorrect");
				}
				else if (nomsString.equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter un nom");
				}
				else if (prenomString.equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter un prénom");
				}
				else if (emailString.equals("")) {
					JOptionPane.showMessageDialog(null, "Ajouter un e-mail");
				}
				else {
					SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
					dateString = dateFormat.format(DateNaissChooser.getDate());
					insert.CreerUtilisateur(idsString, mdpString, vmdpString, nomsString, prenomString, dateString, emailString, roleString);
					dispose();
				}
				
			}
		});
		InscriptionBoutton.setForeground(Color.WHITE);
		InscriptionBoutton.setBackground(new Color(51, 51, 51));
		InscriptionBoutton.setBounds(260, 450, 95, 35);
		panel.add(InscriptionBoutton);
		
		// Boutton annuler
		JButton AnnulerBoutton = new JButton("Annuler");
		AnnulerBoutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connexion connexion = new Connexion();
				dispose();
				connexion.setVisible(true);
				connexion.setLocationRelativeTo(null);
				connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		AnnulerBoutton.setForeground(Color.WHITE);
		AnnulerBoutton.setBackground(new Color(51, 51, 51));
		AnnulerBoutton.setBounds(150, 450, 90, 35);
		panel.add(AnnulerBoutton);
		
		// Partie text
		// text nom
		/*JLabel genreLabel = outils.text("Genre:", 138,8,60,25); 
		genreLabel.setForeground(Color.WHITE);
		genreLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(genreLabel);
		hommeButton.setBounds(210, 7, 80, 23);
		panel.add(hommeButton);
		
		femmeButton.setBounds(315, 7, 80, 23);
		panel.add(femmeButton);
		*/

		
		JLabel NomLabel = outils.text("Nom:", 148, 48, 60, 25);
		NomText = outils.field(210, 50, 185, 25);
		NomLabel.setForeground(Color.WHITE);
		NomLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NomText.setColumns(10);
		panel.add(NomLabel);
		panel.add(NomText);
		
		// text prenom
		JLabel PrenomLabel = outils.text("Prenom:", 123, 98, 80, 25);
		PrenomText = outils.field(210, 100, 185, 25);
		PrenomLabel.setForeground(Color.WHITE);
		PrenomLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrenomText.setColumns(10);
		panel.add(PrenomLabel);
		panel.add(PrenomText);
		
		// text identifiant
		JLabel IDLabel = outils.text("Identifiant:", 103, 148, 100, 25);
		IDText = outils.field(210, 150, 185, 25);
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		IDText.setColumns(10);
		panel.add(IDLabel);
		panel.add(IDText);
		
		// text mdp
		JLabel MDPLabel = outils.text("Mot de passe:", 78, 198, 120, 25);
		MDPLabel.setForeground(Color.WHITE);
		MDPLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(MDPLabel);
		MDPField = new JPasswordField();
		MDPField.setBounds(210, 200, 185, 25);
		panel.add(MDPField);
				
		// text vmdp
		JLabel VMDPLabel = outils.text("Verfication passe:", 50, 250, 170, 25);
		VMDPLabel.setForeground(Color.WHITE);
		VMDPLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));;
		panel.add(VMDPLabel);
		VMDPField = new JPasswordField();
		VMDPField.setBounds(210, 250, 185, 25);
		panel.add(VMDPField);
		
		// text date nassiance
		JLabel DateNaissLabel = outils.text("Date Naissance:", 65, 298, 150, 25);
		DateNaissLabel.setForeground(Color.WHITE);
		DateNaissLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(DateNaissLabel);		
		DateNaissChooser = new JDateChooser();
		DateNaissChooser.setBounds(210, 300, 185, 25);
		panel.add(DateNaissChooser);
		
		// text adresse
		JLabel AdresseLabel = outils.text("e-mail:", 125, 350, 80, 25);
		AdresseLabel.setForeground(Color.WHITE);
		AdresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(AdresseLabel);
		email = outils.field(210, 350, 185, 25);
		panel.add(email);
		
		
		return panel;				
	}
}
