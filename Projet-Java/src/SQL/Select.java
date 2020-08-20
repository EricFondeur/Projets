package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JTable;

import ConnectionBase.MaConnexion;
import Fenetre.Accueil;
import Fenetre.Connexion;
import Message.Compte;
import Outils.Model;

public class Select extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Model model = new Model();
	String numString;
	public void Connexion(String idsString, String mdpString) {
		PreparedStatement ps;
		ResultSet rs;		
		String query="SELECT * from Utilisateur\r\n" + 
				"WHERE id=? \r\n" + 
				"AND pass=?;";
		
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			
			ps.setString(1, idsString);
			ps.setString(2, mdpString);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Accueil MFAccueil = new Accueil();
				MFAccueil.setVisible(true);
			}
			else {
				Compte compte = new Compte();
				compte.setVisible(true);
			}
			
		} catch (Exception ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public JTable DonneUtilisateur(JTable utilisateurTabl, String idString) {
		PreparedStatement ps;
		ResultSet rs;
		String sql = "SELECT Utilisateur.id, Utilisateur.prenom, Utilisateur.nom, utilisateur.role from utilisateur where not(num = 1) ";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			rs = ps.executeQuery();
			utilisateurTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return utilisateurTabl;
	}
	public JTable RechercheUtilisateur(JTable utilisateurTabl, String rechercheString) {
		PreparedStatement ps = null;
		ResultSet rs;
		String sql = "SELECT Utilisateur.id, Utilisateur.prenom, Utilisateur.nom, utilisateur.role from utilisateur where prenom=? and not(num=1)";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			ps.setString(1, rechercheString);
			rs = ps.executeQuery();
			utilisateurTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return utilisateurTabl;
	}
	
	
	public JTable DonneBoutique(JTable boutiqueTabl) {
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select nom, marque, sport, prix, reference\r\n" + 
				"from produit;";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			rs = ps.executeQuery();
			boutiqueTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boutiqueTabl;
	}
	public JTable RechercheBoutique(JTable boutiqueTabl, String rechercheString) {
		PreparedStatement ps = null;
		ResultSet rs;
		String sql = "select nom, marque, sport, prix, reference from produit where nom=?;";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			ps.setString(1, rechercheString);
			rs = ps.executeQuery();
			boutiqueTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return boutiqueTabl;
	}
	
	public JTable donneCommande(JTable CommandeTabl, String idString) {
		PreparedStatement ps;
		ResultSet rs;
		String sql = "select  commande.nom, commande.marque, commande.sport, commande.prixTotal, commande.reference\r\n" + 
				"from Commande, utilisateur where utilisateur.num=commande.u_num and utilisateur.id='"+idString+"'";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			rs = ps.executeQuery();
			CommandeTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CommandeTabl;
	}
	public JTable rechercheCommande(JTable CommandeTabl, String rechercheString) {
		PreparedStatement ps = null;
		ResultSet rs;
		String sql = "select commande.nom, commande.marque, commande.sport, commande.prixTotal, commande.reference from commande where nom=?;";
		try {
			ps = MaConnexion.dbConnector().prepareStatement(sql);
			ps.setString(1, rechercheString);
			rs = ps.executeQuery();
			CommandeTabl.setModel(model.resultSetToTableModel(rs));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CommandeTabl;
	}
	
	
	public String SelectNum(String nom) {
		PreparedStatement ps;
		ResultSet rs;		
		String query="SELECT num FROM utilisateur WHERE id='"+nom+"'";
		
		try {
			ps = MaConnexion.dbConnector().prepareStatement(query);
			rs = ps.executeQuery(query);
			rs.next();
			numString = rs.getString(1);
			rs = ps.executeQuery();
			
		} catch (Exception ex) {
			Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return numString;
	}
	
	public int SelectNombre(String id) {
		int nbr=0;
		PreparedStatement pStatement;
		ResultSet rs;
		String queryString="SELECT COUNT(id) FROM utilisateur";
		
		try {
			pStatement = MaConnexion.dbConnector().prepareStatement(queryString);
			rs=pStatement.executeQuery();
			rs.next();
			nbr = rs.getInt(1);
			rs=pStatement.executeQuery();
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return  nbr;
	}
}
