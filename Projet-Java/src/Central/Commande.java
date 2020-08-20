package Central;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Fenetre.Connexion;
import Message.Ajouter;
import Outils.JswingCF;
import Outils.Model;
import Outils.Tete;
import SQL.Select;

public class Commande {
	
	Select select = new Select();
	Connexion connexion = new Connexion();
	JswingCF outils = new JswingCF();
	Ajouter ajouter = new Ajouter();
	Tete tete = new Tete();
	JPanel CommandePanel =  new JPanel();
	String titre = "Commande";
	Model model = new Model();
	JPanel CommandePanel1 =  new JPanel();
	JPanel detailsCenter = new JPanel();
	JPanel CenterTabl = new JPanel();
	JTextField nomField = new JTextField();
	JTextField marqueField = new JTextField();
	JTextField sportField = new JTextField();
	JTextField prixTotalField = new JTextField();
	JTextField referenceField = new JTextField();
	JTextField quantiTextField = new JTextField();
	JTextField prixField = new JTextField();
	JTextField textSearchField = new JTextField();

	JButton validePrix = new JButton("valider");
	
	private JTable CommandeTabl;
	
	private JPanel createCommande() {
		CommandePanel.setLayout(new BorderLayout(0, 0));
		JPanel northCommandePanel = new JPanel();
		northCommandePanel = tete.enTete(titre, 170, 40, 250, 2);
		CommandePanel.add(northCommandePanel, BorderLayout.NORTH);
			
		JPanel centerCommandePanel =  new JPanel();
		CommandePanel.add(centerCommandePanel, BorderLayout.CENTER);
		centerCommandePanel.setLayout(new BorderLayout(0, 0));
			JPanel northCenterJPanel = new JPanel();
			centerCommandePanel.add(northCenterJPanel, BorderLayout.NORTH);
			northCenterJPanel.setPreferredSize(new Dimension(0, 40));
			northCenterJPanel.add(textSearchField);
			textSearchField.setText("Recherche Commande");
				centerCommandePanel.add(CenterTabl, BorderLayout.CENTER);
				CenterTabl = CommandeParti();
				JButton rechercherButton = new JButton("rechercher");
				northCenterJPanel.add(rechercherButton);
				rechercherButton.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						rechercheCommande();
					}
				});
		
		JPanel centerCommandePanel1 = new JPanel();
		CommandePanel.add(centerCommandePanel1, BorderLayout.WEST);
		centerCommandePanel1.setPreferredSize(new Dimension(50,0));
		
		JPanel eastCommandePanel = new JPanel();
		CommandePanel.add(eastCommandePanel, BorderLayout.EAST);
		eastCommandePanel.setPreferredSize(new Dimension(500,0));
		eastCommandePanel.setLayout(new BorderLayout(0, 0));
		
			eastCommandePanel.add(detailsCenter, BorderLayout.CENTER);
			detailsCenter.setLayout(null);
			detailsCenter=achatParti();
		
		JButton achatBoutton = outils.ButtonBF(255, 255, 255, "Telecharcher", 100, 400, 150, 30);
		achatBoutton.setBackground(new Color(44,62,80));
		achatBoutton.setBorderPainted(false);
		//detailsCenter.add(achatBoutton);
		
		JPanel achatSouth = new JPanel();
		eastCommandePanel.add(achatSouth, BorderLayout.SOUTH);
		
		JPanel southCommandePanel = new JPanel();
		CommandePanel.add(southCommandePanel, BorderLayout.SOUTH);
		southCommandePanel.setPreferredSize(new Dimension(0,50));
		southCommandePanel.setLayout(new BorderLayout(0, 0));
	
		return CommandePanel;
	}
	
	private JPanel CommandeParti() {
		CenterTabl.setLayout(new BorderLayout(0, 0));
		
		
		JPanel southTable =  new JPanel();
		CenterTabl.add(southTable, BorderLayout.SOUTH);

			
			JButton actButton = new JButton("Actualiser");
			actButton.setBackground(new Color(44,62,80));
			actButton.setForeground(Color.WHITE);
			actButton.setBorderPainted(false);
			actButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					donneCommande();
				}
			});
			southTable.add(actButton);
		
		JScrollPane scrollTabl = new JScrollPane();
		CenterTabl.add(scrollTabl, BorderLayout.CENTER);
			CommandeTabl = new JTable() {
				private static final long serialVersionUID = -1006011786843554730L;
				public boolean isCellEditable(int d, int c) {
					return false;
				}
			};
			CommandeTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int row = CommandeTabl.rowAtPoint(arg0.getPoint());
					if (row >=0) {
						
					}
				}
			});
			CommandeTabl.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int ligne = CommandeTabl.getSelectedRow();
					String nomString = CommandeTabl.getModel().getValueAt(ligne, 0).toString();
					String marqueString = CommandeTabl.getModel().getValueAt(ligne, 1).toString();
					String sportString = CommandeTabl.getModel().getValueAt(ligne, 2).toString();
					String prixTotalString = CommandeTabl.getModel().getValueAt(ligne, 3).toString();
					String referenceString = CommandeTabl.getModel().getValueAt(ligne, 4).toString();
					
					nomField.setText(nomString);
					marqueField.setText(marqueString);
					sportField.setText(sportString);
					prixTotalField.setText(prixTotalString);
					referenceField.setText(referenceString);
				}
			});
			scrollTabl.setViewportView(CommandeTabl);
		return CenterTabl;
	}
	
	private JPanel achatParti() {
		
		detailsCenter.add(outils.text("Nom:", 100, 100, 40, 25));
		detailsCenter.add(nomField);
		nomField.setBounds(170,100,100,25);
		
		detailsCenter.add(outils.text("Marque:", 100, 150, 50, 25));
		detailsCenter.add(marqueField);
		marqueField.setBounds(170, 150, 100, 25);
	
		detailsCenter.add(outils.text("Sport:", 100, 200, 50, 25));
		detailsCenter.add(sportField);
		sportField.setBounds(170,200,100,25);
		
		detailsCenter.add(outils.text("Prix Total", 100, 250, 70, 25));
		detailsCenter.add(prixTotalField);
		prixTotalField.setBounds(170,250,100,25);	
		
		detailsCenter.add(outils.text("Référence", 100, 300, 70, 25));
		detailsCenter.add(referenceField);
		referenceField.setBounds(170,300,100,25);
		return detailsCenter;
	}

	public JPanel getCreateCommande() {
		return createCommande();
	}

	private void donneCommande() {
		String idString=connexion.getId();
		CommandeTabl=select.donneCommande(CommandeTabl, idString);
	}
	public void updateTable() {
		donneCommande();
	}
	
	private void rechercheCommande() {
		String rechercheString = textSearchField.getText();
		select.rechercheCommande(CommandeTabl, rechercheString);
	}
}
