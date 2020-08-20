package Central;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Compte.Adresse;
import Compte.Details;
import Outils.JswingCF;
import Outils.Tete;

public class Compte {
	
	JPanel compteJPanel = new JPanel();
	Details details = new Details();
	Adresse adresse = new Adresse();
	JswingCF outils = new JswingCF();
	Tete tete = new Tete();
	String titre = "Compte";
	int haut=100;
	int droite=150;
	
	JLayeredPane layeredPane = new JLayeredPane();
	JPanel detailsPanel = new JPanel();
	JPanel adressePanel = new JPanel();
	
	public JLayeredPane centerPanel() {

		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(createDetails());
		layeredPane.add(createAdresse());
		return layeredPane;
	}
	
	private JPanel createCompte() {
		compteJPanel.setLayout(new BorderLayout(0,0));
		compteJPanel.setBackground(Color.white);
			compteJPanel.add(createNorthComptePanel(), BorderLayout.NORTH);
			compteJPanel.add(createCenterComptePanel(), BorderLayout.CENTER);
				
		return compteJPanel;
	}
	
	private JPanel createNorthComptePanel() {
		JPanel northCompteJPanel =  new JPanel();
		northCompteJPanel = tete.enTete(titre, 130, 40, 250, 2);
		return northCompteJPanel;
	}
	
	private JPanel createCenterComptePanel() {
		JPanel centerComptePanel = new JPanel();
		centerComptePanel.setLayout(new BorderLayout(0,0));
		
		centerComptePanel.add(centerPanel(), BorderLayout.CENTER);
		centerComptePanel.add(northPagePanel(), BorderLayout.NORTH);
		
			centerComptePanel.add(centerMenuPanel(), BorderLayout.WEST);

			JPanel eastPageCompte = new JPanel();
			centerComptePanel.add(eastPageCompte, BorderLayout.EAST);
			eastPageCompte.setPreferredSize(new Dimension(150, 0));
			
			JPanel southPageCompte = new JPanel();
			centerComptePanel.add(southPageCompte, BorderLayout.SOUTH);
			southPageCompte.setPreferredSize(new Dimension(0,50));
		
			return centerComptePanel;
	}
	
	private JPanel northPagePanel() {
		JPanel northPageCompte = new JPanel();
		northPageCompte.setPreferredSize(new Dimension(0,70));
		northPageCompte.setLayout(new BorderLayout());
			JPanel westNorth =  new JPanel();
			northPageCompte.add(westNorth, BorderLayout.WEST);
			
			JPanel eastNorth = new JPanel();
			eastNorth.setLayout(new BorderLayout());
			northPageCompte.add(eastNorth, BorderLayout.EAST);
				JPanel westPanel = new JPanel();
				eastNorth.add(westPanel, BorderLayout.WEST);
					JButton detailsButton = outils.buttonBF("Details", 238, 238, 238);
					mouseEntSort(detailsButton);
					westPanel.add(detailsButton);
					detailsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							switchPanels(detailsPanel);
							
						}
					});
					
				JPanel centerPanel = new JPanel();
				eastNorth.add(centerPanel, BorderLayout.CENTER);
					JButton adresseButton = outils.buttonBF("Adresse", 238, 238, 238);
					mouseEntSort(adresseButton);
					centerPanel.add(adresseButton);
					adresseButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							switchPanels(adressePanel);
							
						}
					});
			
			JPanel northNorth = new JPanel();
			northPageCompte.add(northNorth, BorderLayout.NORTH);
		return northPageCompte;
	}
	
	private JPanel centerMenuPanel() {
		JPanel westPageCompte = new JPanel();
		westPageCompte.setPreferredSize(new Dimension(150, 0));
		westPageCompte.setLayout(new BorderLayout(0, 0));
		JPanel westTitreJPanel = new JPanel();
		westPageCompte.add(westTitreJPanel, BorderLayout.NORTH);	
		return westPageCompte;
	}
	
	public JPanel getCreateCompte() {
		return createCompte();
	}
	
	private JPanel createDetails() {
		return detailsPanel = details.getCreateCenterCompte();
	}
	private JPanel createAdresse() {
		return adressePanel = adresse.getCreateAdressePage();
	}
	
	private void mouseEntSort(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(64,82,100));
				button.setForeground(new Color(238,238,238));
			}
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(new Color(238,238,238));
				button.setForeground(Color.black);
			}
		});
	}
	// Methode pour changer la partie central
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
