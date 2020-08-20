package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ConnectionBase.MaConnexion;
import ConnectionBase.Personne;
import Fenetre.Connexion;
import Fenetre.Inscription;

public class Update {
	Connexion connexion = new Connexion();
	Personne personne = new Personne();
	public void UpdateDetails(String nomString, String prenomString, String telephoneString, String dateNaissString) {
		String idString=connexion.getId();
		PreparedStatement ps;
		String query = "UPDATE utilisateur SET nom = ?, prenom = ?, DateNaiss= ?, telephone= ? WHERE id= ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, nomString);
			ps.setString(2, prenomString);
			ps.setString(3, dateNaissString);
			ps.setString(4, telephoneString);
			ps.setString(5, idString);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "utilisateur modifier");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void UpdateMDP(String MDPString, String NMDPString, String CMDPString) {
		if (MDPString.equals(personne.GetPass())) {
			if (NMDPString.equals(CMDPString)){
				String idString=connexion.getId();
				PreparedStatement ps;
				String query = "UPDATE utilisateur SET pass = ?, vpass = ? WHERE id= ?";
				try {
					ps = MaConnexion.dbConnector().prepareStatement(query);
					
					ps.setString(1, NMDPString);
					ps.setString(2, CMDPString);
					ps.setString(3, idString);
					if (ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "utilisateur modifier");
					}
					else 
						JOptionPane.showMessageDialog(null, "raté");
				} catch (SQLException ex) {
					Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "confirmation de mot de passe faux");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "mot de passe acutel faux");
		}
	}
	
	public void UpdateAdresse(String numero, String adresse, String CP, String ville, String pays) {
		String idString=connexion.getId();
		PreparedStatement ps;
		String query = "UPDATE utilisateur SET numero = ?, adresse = ?, CodePostal = ?, ville = ?, pays = ? WHERE id= ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, numero);
			ps.setString(2, adresse);
			ps.setString(3, CP);
			ps.setString(4, ville);
			ps.setString(5, pays);
			ps.setString(6, idString);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "utilisateur modifier");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void UpdateMail(String mail, String nMail, String cMail) {
		if (mail.equals(personne.getMail())) {
			if (nMail.equals(cMail)) {
				String idString=connexion.getId();
				PreparedStatement ps;
				String query = "UPDATE utilisateur SET adresseMail = ? WHERE id= ?";
				try {
					ps = MaConnexion.dbConnector().prepareStatement(query);
					
					ps.setString(1, cMail);
					ps.setString(2, idString);
					if (ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "utilisateur modifier");
					}
					else 
						JOptionPane.showMessageDialog(null, "raté");
				} catch (SQLException ex) {
					Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "confirmation e-mail faux");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "e-mail acutel faux");
		}
	}
	
	public void UpdateUtilisateur (String nomString, String prenomString, String gradeString, String idString) {
		PreparedStatement ps;
		String query = "UPDATE utilisateur SET nom = ?, prenom = ?, role = ? WHERE id= ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, nomString);
			ps.setString(2, prenomString);
			ps.setString(3, gradeString);
			ps.setString(4, idString);

			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "utilisateur modifier");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
