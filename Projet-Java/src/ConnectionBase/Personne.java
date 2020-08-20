package ConnectionBase;

import java.sql.ResultSet;
import java.sql.Statement;

import Fenetre.Connexion;

public class Personne {
	Connexion connexion = new Connexion();
	
	String iDString = connexion.getId();
	String prenomString="";
	String numString="";
	String nomString="";
	String dateNaissString="";
	String telephoneString="telephone";
	String mailString="";
	String numeroString="numero";
	String adresseString="adresse";
	String codePostalString="codePostal";
	String villeString="ville";
	String paysString="pays";
	String roleString="";
	String motDePass="";
	
	public void utilisateur() {
		String lsSQL = "SELECT num, prenom, nom, dateNaiss,telephone, adresseMail, numero, adresse, CodePostal, ville, pays, role, pass FROM utilisateur WHERE id='"+iDString+"'";
		try {
			Statement stat = MaConnexion.dbConnector().createStatement();
			ResultSet rs = stat.executeQuery(lsSQL);
			rs.next();
			numString = rs.getString(1);
			prenomString = rs.getString(2);
			nomString =rs.getString(3);
			dateNaissString = rs.getString(4);
			telephoneString = rs.getString(5);
			mailString = rs.getString(6);
			numeroString = rs.getString(7);
			adresseString = rs.getString(8);
			codePostalString = rs.getString(9);
			villeString = rs.getString(10);
			paysString = rs.getString(11);
			roleString = rs.getString(12);
			motDePass = rs.getString(13);
			
			rs.close();
			stat.close();
	      }
	      catch(Exception e){ prenomString = "Introuvable"; 
	      }
	}
	public String getNum() {
		utilisateur();
		return numString;
	}
	public String getPrenom() {
		utilisateur();
		return prenomString;
	}
	public String getNom() {
		utilisateur();
		return nomString;
	}
	public String getDateNaiss() {
		utilisateur();
		return dateNaissString;
	}
	public String getTelephone() {
		utilisateur();
		return telephoneString;
	}
	public String getMail() {
		utilisateur();
		return mailString;
	}
	public String getNumero() {
		utilisateur();
		return numeroString;
	}
	public String getAdresse() {
		utilisateur();
		return adresseString;
	}
	public String GetCP() {
		utilisateur();
		return codePostalString;
	}
	public String GetVille() {
		utilisateur();
		return villeString;
	}
	public String GetPays() {
		utilisateur();
		return paysString;
	}
	public String GetRole() {
		utilisateur();
		return roleString;
	}
	public String GetPass() {
		utilisateur();
		return motDePass;
	}
}