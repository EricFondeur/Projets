package SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import ConnectionBase.MaConnexion;
import Fenetre.Inscription;

public class Delete {
	public void DeleteUtilisateur(String id) {
		PreparedStatement ps;
		String query = "DELETE FROM utilisateur WHERE id= ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, id);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "utilisateur supprimé");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void DeleteCommande(String id) {
		PreparedStatement ps;
		String query = "DELETE FROM commande WHERE u_num = ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, id);
			if (ps.executeUpdate()>0) {
				
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void DeletePorduit(String nomString) {
		PreparedStatement ps;
		String query = "DELETE FROM produit WHERE nom= ?";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, nomString);
			if (ps.executeUpdate()>0) {
				JOptionPane.showMessageDialog(null, "produit supprimé");
			}
			else 
				JOptionPane.showMessageDialog(null, "raté");
		} catch (SQLException ex) {
			Logger.getLogger(Inscription.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
