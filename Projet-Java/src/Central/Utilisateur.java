package Central;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import SQL.Select;
import SQL.Update;

public class Utilisateur {
	
	Select select = new Select();
	Update update = new Update();
	Personne personne = new Personne();
	Delete delete = new Delete();
	JswingCF outils = new JswingCF();
	Ajouter ajouter = new Ajouter();
	Tete tete = new Tete();
	JPanel utilisateurPanel =  new JPanel();
	String titre = "Utilisateur";
	Model model = new Model();
	JPanel utilisateurPanel1 =  new JPanel();
	JPanel detailsCenter = new JPanel();
	JPanel CenterTabl = new JPanel();
	JTextField nomField = new JTextField();
	JTextField prenomField = new JTextField();
	String[] gradeBoxStrings = {"administrateur", "utilisateur"};
	JComboBox<String> gradeBox = new JComboBox<String>(gradeBoxStrings);
	JTextField textSearchField = new JTextField();
	
	JTextField sportField = new JTextField();
	JTextField referenceField = new JTextField();
	JTextField quantiTextField = new JTextField();
	JTextField prixField = new JTextField();
	JTextField prixTotalField = new JTextField();
	JButton validePrix = new JButton("valider");
	
	String idString;
	String nomString;
	String prenomString;
	String gradeString;
	
	private JTable utilisateurTabl;
	
	private JPanel createUtilisateur() {
		utilisateurPanel.setLayout(new BorderLayout(0, 0));
		JPanel northUtilisateurPanel = new JPanel();
		northUtilisateurPanel = tete.enTete(titre, 150, 40, 250, 2);
		utilisateurPanel.add(northUtilisateurPanel, BorderLayout.NORTH);
			
		JPanel centerUtilisateurPanel =  new JPanel();
		utilisateurPanel.add(centerUtilisateurPanel, BorderLayout.CENTER);
		centerUtilisateurPanel.setLayout(new BorderLayout(0, 0));
			JPanel northCenterJPanel = new JPanel();
			centerUtilisateurPanel.add(northCenterJPanel, BorderLayout.NORTH);
			northCenterJPanel.setPreferredSize(new Dimension(0, 40));
			northCenterJPanel.add(textSearchField);
			textSearchField.setText("Recherche prenom");
				centerUtilisateurPanel.add(CenterTabl, BorderLayout.CENTER);
				CenterTabl = utilisateurParti();
				JButton rechercherButton = new JButton("rechercher");
				northCenterJPanel.add(rechercherButton);
				rechercherButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						rechercheUtilisateur();
					}
				});
		
		JPanel centerUtilisateurPanel1 = new JPanel();
		utilisateurPanel.add(centerUtilisateurPanel1, BorderLayout.WEST);
		centerUtilisateurPanel1.setPreferredSize(new Dimension(50,0));
		
		JPanel eastUtilisateurPanel = new JPanel();
		utilisateurPanel.add(eastUtilisateurPanel, BorderLayout.EAST);
		eastUtilisateurPanel.setPreferredSize(new Dimension(500,0));
		eastUtilisateurPanel.setLayout(new BorderLayout(0, 0));
		
			eastUtilisateurPanel.add(detailsCenter, BorderLayout.CENTER);
			detailsCenter.setLayout(null);
			detailsCenter=achatParti();
		
		JButton modifButton = outils.ButtonBF(255, 255, 255, "Modifier", 100, 250, 100, 30);
		modifButton.setBackground(new Color(44,62,80));
		modifButton.setBorderPainted(false);
		detailsCenter.add(modifButton);
		modifButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				gradeString=gradeBox.getSelectedItem().toString();
				update.UpdateUtilisateur(nomString, prenomString, gradeString, idString);
				donneUtilisateur();
			}
		});
		
		
		JButton suprButton = new JButton("Supprimer utilisateur");
		suprButton.setBounds(220, 250, 170, 30);
		suprButton.setBackground(new Color(44,62,80));
		suprButton.setForeground(Color.white);
		suprButton.setBorderPainted(false);
		suprButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				String numString = select.SelectNum(nomString);
				System.out.print(numString);
				delete.DeleteCommande(numString);
				delete.DeleteUtilisateur(idString);
				donneUtilisateur();
			}
		});
		detailsCenter.add(suprButton);
	
		
		JPanel achatSouth = new JPanel();
		eastUtilisateurPanel.add(achatSouth, BorderLayout.SOUTH);
		
		JPanel southUtilisateurPanel = new JPanel();
		utilisateurPanel.add(southUtilisateurPanel, BorderLayout.SOUTH);
		southUtilisateurPanel.setPreferredSize(new Dimension(0,50));
		southUtilisateurPanel.setLayout(new BorderLayout(0, 0));
	
		return utilisateurPanel;
	}
	
	private JPanel utilisateurParti() {
		CenterTabl.setLayout(new BorderLayout(0, 0));
		
		
		JPanel southTable =  new JPanel();
		CenterTabl.add(southTable, BorderLayout.SOUTH);

			
			JButton actButton = new JButton("Actualiser");
			actButton.setBackground(new Color(44,62,80));
			actButton.setForeground(Color.WHITE);
			actButton.setBorderPainted(false);
			actButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					donneUtilisateur();
				}
			});
			southTable.add(actButton);

		JScrollPane scrollTabl = new JScrollPane();
		CenterTabl.add(scrollTabl, BorderLayout.CENTER);
			utilisateurTabl = new JTable() {
				private static final long serialVersionUID = -1006011786843554730L;
				public boolean isCellEditable(int d, int c) {
					return false;
				}
			};
			utilisateurTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int row = utilisateurTabl.rowAtPoint(arg0.getPoint());
					if (row >=0) {
						
					}
				}
			});
			utilisateurTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int ligne = utilisateurTabl.getSelectedRow();
					idString = utilisateurTabl.getModel().getValueAt(ligne, 0).toString();
					nomString = utilisateurTabl.getModel().getValueAt(ligne, 1).toString();
					prenomString = utilisateurTabl.getModel().getValueAt(ligne, 2).toString();
					gradeString = utilisateurTabl.getModel().getValueAt(ligne, 3).toString();
					
					nomField.setText(nomString);					
					prenomField.setText(prenomString);
					if (gradeString.equals("administrateur")) {
						gradeBox.setSelectedIndex(0);
					}
					else {
						gradeBox.setSelectedIndex(1);
					}
				}
			});
			scrollTabl.setViewportView(utilisateurTabl);
		return CenterTabl;
	}
	
	private JPanel achatParti() {
		
		detailsCenter.add(outils.text("Nom:", 100, 100, 40, 25));
		detailsCenter.add(nomField);
		nomField.setBounds(170,100,150,25);
		
		detailsCenter.add(outils.text("Prenom:", 100, 150, 50, 25));
		detailsCenter.add(prenomField);
		prenomField.setBounds(170,150,150,25);
	
		detailsCenter.add(outils.text("Grade:", 100, 200, 50, 25));
		detailsCenter.add(gradeBox);
		gradeBox.setBounds(170,200,150,25);
		gradeBox.setBackground(Color.WHITE);
		return detailsCenter;
	}

	public JPanel getCreateUtilisateur() {
		return createUtilisateur();
	}

	private void donneUtilisateur() {
		idString = personne.getNum();
		utilisateurTabl=select.DonneUtilisateur(utilisateurTabl, idString);
	}
	public void updateTable() {
		donneUtilisateur();
	}
	
	private void rechercheUtilisateur() {
		String rechercheString = textSearchField.getText();
		utilisateurTabl=select.RechercheUtilisateur(utilisateurTabl, rechercheString);
	}
}

