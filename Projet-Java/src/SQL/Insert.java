package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ConnectionBase.MaConnexion;
import Fenetre.Connexion;
import Fenetre.Inscription;

public class Insert {
	public void commande(String nomString, String marqueString, String sportString, String prixTotal, String referenceString, String numString) {
		PreparedStatement ps;
		String query = "INSERT INTO commande( nom, marque, sport, prixTotal, reference, u_num) VALUES (?,?,?,?,?,?)";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, nomString);
			ps.setString(2, marqueString);
			ps.setString(3, sportString);
			ps.setString(4, prixTotal);
			ps.setString(5, referenceString);
			ps.setString(6, numString);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Produit acheté");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void CreerUtilisateur(String idsString, String mdpString, String vmdpString, String nomsString, String prenomString, String dateString, String emailString, String roleString) {
		PreparedStatement ps;
		String query = "INSERT INTO utilisateur( id, pass, vpass, nom, prenom, dateNaiss, adresseMail, role) VALUES (?,?,?,?,?,?,?,?)";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, idsString);
			ps.setString(2, mdpString);
			ps.setString(3, vmdpString);
			ps.setString(4, nomsString);
			ps.setString(5, prenomString);
			ps.setString(6, dateString);
			ps.setString(7, emailString);
			ps.setString(8, roleString);
			
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Nouvelle utilisateur ajouter");
				Connexion connexion = new Connexion();
				connexion.setVisible(true);
				connexion.setLocationRelativeTo(null);
				connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void AjoutProduit(String nom, String marque, String sport, int prix, String reference) {
		PreparedStatement ps;
		String query = "INSERT INTO produit (nom, marque, sport, prix, reference)\r\n" + 
				"VALUES (?,?,?,?,?);";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, nom);
			ps.setString(2, marque);
			ps.setString(3, sport);
			ps.setInt(4, prix);
			ps.setString(5, reference);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "Nouveau produit ajouté");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
