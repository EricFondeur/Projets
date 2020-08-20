package Message;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.Insert;

public class Ajouter extends JFrame{
	/**
	 * 
	 */
	Insert insert = new Insert();
	private static final long serialVersionUID = 1L;
	JPanel contentPane =  (JPanel) this.getContentPane();
	int MousepX;
	int MousepY;
	
	String nom;
	String marque;
	String sport;
	Integer prix;
	String reference;
	int FPR;
	private JTextField nomText;
	private JTextField marqueText;
	private JTextField prixText;
	private JTextField refText;
	private JTextField FP;
	JComboBox<String> sportBox = new JComboBox<String>();
	
	JPanel panel = new JPanel();

	public Ajouter() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//contentPane.add(InscriptionFentre());
		contentPane.add(ajoutPageJPanel());
		
	}
	
	JPanel ajoutPageJPanel() {
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
		
		// text ajout
		JLabel ajoutLabel = new JLabel("Ajouter");
		ajoutLabel.setForeground(new Color(255, 255, 255));
		ajoutLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		ajoutLabel.setBounds(45, 0, 130, 40);
		panelHead.add(ajoutLabel);
		
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
		panel.setLayout(null);
		panel.setBackground(new Color(44, 62, 80));
		panel.setBounds(0, 40, 500, 460);
		getContentPane().add(panel);
		

		textLabel();
		champText();
		boutton();
		
		return panel;
	}
	
	private void textLabel() {
		// text Nom
		JLabel NomLabel = new JLabel("Nom:");
		NomLabel.setForeground(Color.WHITE);
		NomLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NomLabel.setBounds(150, 30, 60, 25);
		panel.add(NomLabel);
		
		// text marque
		JLabel marqueLabel = new JLabel("Marque:");
		marqueLabel.setForeground(Color.WHITE);
		marqueLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		marqueLabel.setBounds(125, 80, 80, 25);
		panel.add(marqueLabel);
		
		// text identifiant
		JLabel sportLabel = new JLabel("Sport:");
		sportLabel.setForeground(Color.WHITE);
		sportLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		sportLabel.setBounds(145, 130, 60, 25);
		panel.add(sportLabel);
		
		JLabel prixLabel = new JLabel("Prix:");
		prixLabel.setForeground(Color.WHITE);
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		prixLabel.setBounds(160, 180, 40, 25);
		panel.add(prixLabel);
		
		JLabel  referenceLabel = new JLabel("Reférence:");
		referenceLabel.setForeground(Color.WHITE);
		referenceLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		referenceLabel.setBounds(105, 230, 100, 25);
		panel.add(referenceLabel);
		

	}
	
	private void champText() {
		nomText = new JTextField();
		nomText.setBounds(210, 30, 110, 25);
		panel.add(nomText);
		nomText.setColumns(10);
		
		marqueText = new JTextField();
		marqueText.setBounds(210, 80, 110, 25);
		panel.add(marqueText);
		marqueText.setColumns(10);
		
		sportBox.addItem("Tennis");
		sportBox.addItem("Basket");
		sportBox.addItem("Foot");
		sportBox.addItem("Volley");
		sportBox.addItem("Ping-Pong");
		sportBox.addItem("Aqua-Poney");
		sportBox.setSelectedItem(null);		
		sportBox.setBackground(Color.WHITE);
		sportBox.setBounds(210, 130, 110, 25);
		panel.add(sportBox);
		
		prixText = new JTextField();
		prixText.setBounds(210, 180, 110, 25);
		panel.add(prixText);
		prixText.setColumns(10);
		
		refText = new JTextField();
		refText.setBounds(210, 230, 110, 25);
		panel.add(refText);
		refText.setColumns(10);

	}
	
	private void boutton() {

		JButton AnnulerBouton = new JButton("Annuler");
		AnnulerBouton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		AnnulerBouton.setBackground(new Color(51, 51, 51));
		AnnulerBouton.setForeground(new Color(255, 255, 255));
		AnnulerBouton.setBounds(130, 370, 90, 35);
		panel.add(AnnulerBouton);
		
		JButton AjoutButton = new JButton("Ajouter");
		AjoutButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				nom = nomText.getText();
				marque = marqueText.getText();
				sport = (String)sportBox.getSelectedItem();
				prix = Integer.parseInt(prixText.getText());
				reference = refText.getText();
				verification();
				ajouteBD();
				nomText.setText("");
				marqueText.setText("");
				prixText.setText("");
				sportBox.setSelectedIndex(0);
				refText.setText("");
				dispose();
			}
		});
		AjoutButton.setBackground(new Color(51, 51, 51));
		AjoutButton.setForeground(new Color(255, 255, 255));
		AjoutButton.setBounds(300, 370, 90, 35);
		panel.add(AjoutButton);
		
	}
	
	private void verification() {
		if (nom.equals("")) {
			JOptionPane.showConfirmDialog(null, "Ajoutez un nom");
		}
		else if (marque.equals("")) {
			JOptionPane.showConfirmDialog(null, "Ajoutez une marque");
		}
		else if (sport.equals("")) {
			JOptionPane.showConfirmDialog(null, "Ajoutez un sport");
		}
		else if (prix.equals(null)){
			JOptionPane.showConfirmDialog(null, "Ajoutez un prix");
		}
		else if (reference.equals("")){
			JOptionPane.showConfirmDialog(null, "Ajouter une reférence");
		}
	}
	
	private void ajouteBD() {
		insert.AjoutProduit(nom, marque, sport, prix, reference);
	}
}
