package Central;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ConnectionBase.Personne;
import Outils.JswingCF;
import Outils.Tete;
import SQL.Select;

public class Principal {
	
	JswingCF outils = new JswingCF();
	
	int nbrUtilisateur;
	Tete tete = new Tete();
	JPanel AccueilPanel =  new JPanel();
	String titre = "Accueil";
	Select select = new Select();
	Personne personne = new Personne();
	private JPanel createAccueil() {
		AccueilPanel.setLayout(new BorderLayout());
		JPanel northAccueilJPanel = new JPanel();
		northAccueilJPanel = tete.enTete(titre, 130, 40, 250, 2);
		AccueilPanel.add(northAccueilJPanel, BorderLayout.NORTH);
		AccueilPanel.add(centerAccueil(), BorderLayout.CENTER);
		return AccueilPanel;
	}
	
	private JPanel centerAccueil() {
		JPanel centerAccueilJPanel = new JPanel();
		nbrUtilisateur = select.SelectNombre(personne.getNum());
		JLabel nombreUtilisateur = new JLabel("nombre d'utilisateur: ");
		centerAccueilJPanel.add(nombreUtilisateur);
		nombreUtilisateur.setBounds(150, 40, 100, 2);
		JLabel nbr = new JLabel(Integer.toString(nbrUtilisateur));
		centerAccueilJPanel.add(nbr);
		nbr.setBounds(200, 40, 20, 2);
		
		return centerAccueilJPanel;
	}
	
	public JPanel getCreateAccueil() {
		return createAccueil();
	}

}
