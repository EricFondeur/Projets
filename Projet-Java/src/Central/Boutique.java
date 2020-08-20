package Central;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ConnectionBase.Personne;
import Message.Ajouter;
import Outils.JswingCF;
import Outils.Model;
import Outils.Tete;
import SQL.Delete;
import SQL.Insert;
import SQL.Select;

public class Boutique {
	
	Delete delete = new Delete();
	Insert insert = new Insert();
	Select select = new Select();
	Personne personne = new Personne();
	JswingCF outils = new JswingCF();
	Ajouter ajouter = new Ajouter();
	Tete tete = new Tete();
	JPanel boutiquePanel =  new JPanel();
	String titre = "Boutique";
	Model model = new Model();
	JPanel boutiquePanel1 =  new JPanel();
	JPanel achatCenter = new JPanel();
	JPanel CenterTabl = new JPanel();
	JTextField textSearchField = new JTextField();
	JTextField nomField = new JTextField();
	JTextField marqueField = new JTextField();
	JTextField sportField = new JTextField();
	JTextField referenceField = new JTextField();
	JTextField quantiTextField = new JTextField();
	JTextField prixField = new JTextField();
	JTextField prixTotalField = new JTextField();
	JButton validePrix = new JButton("valider");
	
	String nomString;
	String marqueString;
	String sportString;
	String prixString;
	String referenceString;
	String prixTotal;
	String quantiteString;
	
	private JTable boutiqueTabl;
	
	private JPanel createBoutique() {
		boutiquePanel.setLayout(new BorderLayout(0, 0));
		JPanel northBoutiqueJPanel = new JPanel();
		northBoutiqueJPanel = tete.enTete(titre, 140, 40, 250, 2);
		boutiquePanel.add(northBoutiqueJPanel, BorderLayout.NORTH);
			
		JPanel centerBoutiqueJPanel =  new JPanel();
		boutiquePanel.add(centerBoutiqueJPanel, BorderLayout.CENTER);
		centerBoutiqueJPanel.setLayout(new BorderLayout(0, 0));
			JPanel northCenterJPanel = new JPanel();
			centerBoutiqueJPanel.add(northCenterJPanel, BorderLayout.NORTH);
			northCenterJPanel.setPreferredSize(new Dimension(0, 40));
			northCenterJPanel.add(textSearchField);
			textSearchField.setText("Recherche nom");
				centerBoutiqueJPanel.add(CenterTabl, BorderLayout.CENTER);
				CenterTabl = boutiqueParti();
			JButton rechercherButton = new JButton("rechercher");
			northCenterJPanel.add(rechercherButton);
			rechercherButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					rechercheBoutique();
				}
			});
				
			
		
		JPanel westBoutiqueJPanel = new JPanel();
		boutiquePanel.add(westBoutiqueJPanel, BorderLayout.WEST);
		westBoutiqueJPanel.setPreferredSize(new Dimension(50,0));
		
		JPanel eastBoutiqueJPanel = new JPanel();
		boutiquePanel.add(eastBoutiqueJPanel, BorderLayout.EAST);
		eastBoutiqueJPanel.setPreferredSize(new Dimension(500,0));
		eastBoutiqueJPanel.setLayout(new BorderLayout(0, 0));
		
			eastBoutiqueJPanel.add(achatCenter, BorderLayout.CENTER);
			achatCenter.setLayout(null);
			achatCenter=achatParti();
		
		JButton achatBoutton = outils.ButtonBF(255, 255, 255, "Acheter", 250, 450, 100, 30);
		achatBoutton.setBackground(new Color(44,62,80));
		achatBoutton.setBorderPainted(false);
		achatCenter.add(achatBoutton);
		achatBoutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				commande();
			}
		});
		JButton suprButton = outils.ButtonBF(255, 255, 255, "Supprimer", 100,450, 100, 30);
		suprButton.setBackground(new Color(44,62,80));
		suprButton.setBorderPainted(false);
		achatCenter.add(suprButton);
		suprButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				DeletePorduit();
				donneBoutique();
			}
		});
		if (personne.GetRole().equals("utilisateur")) {
			suprButton.setVisible(false);
		}
		
		JPanel achatSouth = new JPanel();
		eastBoutiqueJPanel.add(achatSouth, BorderLayout.SOUTH);
		
		JPanel southBoutiqueJPanel = new JPanel();
		boutiquePanel.add(southBoutiqueJPanel, BorderLayout.SOUTH);
		southBoutiqueJPanel.setPreferredSize(new Dimension(0,50));
		southBoutiqueJPanel.setLayout(new BorderLayout(0, 0));
	
		return boutiquePanel;
	}
	
	private JPanel boutiqueParti() {
		CenterTabl.setLayout(new BorderLayout(0, 0));
		
		
		JPanel southTable =  new JPanel();
		CenterTabl.add(southTable, BorderLayout.SOUTH);
			JButton ajoutButton = new JButton("Ajouter");
			ajoutButton.setBackground(new Color(44,62,80));
			ajoutButton.setForeground(Color.WHITE);
			ajoutButton.setBorderPainted(false);
			ajoutButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ajouter.setVisible(true);
					ajouter.setLocationRelativeTo(null);
					ajouter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					donneBoutique();
				}
			});
			southTable.add(ajoutButton);
			if (personne.GetRole().equals("utilisateur")) {
				ajoutButton.setVisible(false);
			}
			
			JButton actButton = new JButton("Actualiser");
			actButton.setBackground(new Color(44,62,80));
			actButton.setForeground(Color.WHITE);
			actButton.setBorderPainted(false);
			actButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					donneBoutique();
				}
			});
			southTable.add(actButton);
		
		JScrollPane scrollTabl = new JScrollPane();
		CenterTabl.add(scrollTabl, BorderLayout.CENTER);
			boutiqueTabl = new JTable() {
				private static final long serialVersionUID = -1006011786843554730L;
				public boolean isCellEditable(int d, int c) {
					return false;
				}
			};
			boutiqueTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int row = boutiqueTabl.rowAtPoint(arg0.getPoint());
					if (row >=0) {
						
					}
				}
			});
			boutiqueTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int ligne = boutiqueTabl.getSelectedRow();
					nomString = boutiqueTabl.getModel().getValueAt(ligne, 0).toString();
					marqueString = boutiqueTabl.getModel().getValueAt(ligne, 1).toString();
					sportString = boutiqueTabl.getModel().getValueAt(ligne, 2).toString();
					prixString = boutiqueTabl.getModel().getValueAt(ligne, 3).toString();
					referenceString = boutiqueTabl.getModel().getValueAt(ligne, 4).toString();
					
					nomField.setText(nomString);		
					marqueField.setText(marqueString);
					sportField.setText(sportString);
					referenceField.setText(referenceString);
					prixField.setText(prixString);
					prixTotalField.setText(null);
					quantiTextField.setText(null);
					
				}
			});
			scrollTabl.setViewportView(boutiqueTabl);
		return CenterTabl;
	}
	
	private JPanel achatParti() {
		
		achatCenter.add(outils.text("Nom:", 100, 100, 40, 25));
		achatCenter.add(nomField);
		nomField.setBounds(170,100,100,25);
		
		achatCenter.add(outils.text("Marque:", 100, 150, 50, 25));
		achatCenter.add(marqueField);
		marqueField.setBounds(170,150,100,25);
		
		achatCenter.add(outils.text("Sport:", 100, 200, 50, 25));
		achatCenter.add(sportField);
		sportField.setBounds(170,200,100,25);
		
		achatCenter.add(outils.text("Ref\u00E9rence:", 100, 250, 70, 25));
		achatCenter.add(referenceField);
		referenceField.setBounds(170,250,100,25);
		
		achatCenter.add(outils.text("Prix: ", 100, 300, 60, 25));
		achatCenter.add(prixField);
		prixField.setBounds(170,300,100,25);
		
		achatCenter.add(outils.text("Quantit\u00E9:", 100, 350, 60, 25));
		achatCenter.add(quantiTextField);
		quantiTextField.setBounds(170,350,100,25);
		achatCenter.add(validePrix);
		validePrix.setBounds(300,350,60,25);
		validePrix.setBorder(null);
		validePrix.setBackground(new Color(64,82,100));
		validePrix.setFocusPainted(false);
		validePrix.setForeground(new Color(255,255,255));
		validePrix.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int prix = Integer.parseInt(prixField.getText());
				int quantite = Integer.parseInt(quantiTextField.getText());
				
				String prixTotalString = String.valueOf(prix*quantite);
				prixTotalField.setText(prixTotalString);
			}
		});

		achatCenter.add(outils.text("Prix Total:", 100, 400, 60, 25));
		achatCenter.add(prixTotalField);
		prixTotalField.setBounds(170,400,100,25);
		return achatCenter;
	}

	public JPanel getCreateBoutique() {
		return createBoutique();
	}

	private void donneBoutique() {
		boutiqueTabl=select.DonneBoutique(boutiqueTabl);
	}
	public void updateTable() {
		donneBoutique();
	}
	
	private void rechercheBoutique() {
		String rechercheString = textSearchField.getText();
		boutiqueTabl=select.RechercheBoutique(boutiqueTabl, rechercheString);
	}
	
	private void DeletePorduit() {
		nomString = nomField.getText();
		delete.DeletePorduit(nomString);
	}
	
	private void commande() {
		String numString=personne.getNum();
		prixTotal=prixTotalField.getText();
		quantiteString=quantiTextField.getText();
		insert.commande(nomString, marqueString, sportString, prixTotal, referenceString, numString);
	}
}

