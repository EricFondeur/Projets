package Compte;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ConnectionBase.Personne;
import Outils.JswingCF;
import Outils.Tete;
import SQL.Update;


public class Adresse {
	Update update=new Update();
	Personne sql = new Personne();
	JswingCF outils = new JswingCF();
	Tete tete = new Tete();
	int haut=70;
	int droite=250;
	
	String numeroString = sql.getNumero();
	String adresseString = sql.getAdresse();
	String cPString = sql.GetCP();
	String paysString = sql.GetPays();
	String villeString = sql.GetVille();
	String mailString=sql.getMail();
	String nmailString="";
	String cmailString="";
	
	JTextField numeroField = new JTextField(numeroString);
	JTextField adresseField = new JTextField(adresseString);
	JTextField cPField = new JTextField(cPString);
	JTextField villeField = new JTextField(villeString);
	JTextField paysField = new JTextField(paysString);
	JTextField mailField = new JTextField(mailString);
	JTextField newMailField = new JTextField("");
	JTextField confirmerMailField = new JTextField("");
	
	private JPanel createAdressePage() {
		JPanel centerPageCompte = new JPanel();
		centerPageCompte.setBackground(Color.WHITE);
		centerPageCompte.setLayout(null);
			centerPageCompte.add(outils.textCF("Adresse", droite, haut, 100, 40, 22));
			centerPageCompte.add(outils.text("Adresse de livraison", droite, haut+50, 140, 20));
			centerPageCompte.add(tete.separator(droite, haut+70, 600, 2));
			
			centerPageCompte.add(outils.text("numero de rue:", droite+100, haut+100, 120, 20));
			numeroField.setBounds(droite+100, haut+120, 150, 20);
			centerPageCompte.add(numeroField);
			
			centerPageCompte.add(outils.text("adresse:", droite+300, haut+100, 60, 20));
			adresseField.setBounds(droite+300, haut+120, 150,20);
			centerPageCompte.add(adresseField);
			
			centerPageCompte.add(outils.text("code postal:", droite+100, haut+160, 130, 20));
			cPField.setBounds(droite+100, haut+180, 150, 20);
			centerPageCompte.add(cPField);
			
			centerPageCompte.add(outils.text("Ville:", droite+300, haut+160, 150, 20));
			villeField.setBounds(droite+300, haut+180, 150, 20);
			centerPageCompte.add(villeField);
			
			centerPageCompte.add(outils.text("pays:", droite+100, haut+220, 130, 20));
			paysField.setBounds(droite+100, haut+240, 150, 20);
			centerPageCompte.add(paysField);
			JButton saveButton=outils.ButtonBF(255, 255, 255, "valider", droite+100, haut+280, 80, 30);
			saveButton.setBorderPainted(false);
			saveButton.setFocusPainted(false);
			saveButton.setBackground(new Color(64,82,100));
			centerPageCompte.add(saveButton);
			saveButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					numeroString=numeroField.getText();
					adresseString=adresseField.getText();
					cPString=cPField.getText();
					villeString=villeField.getText();
					paysString=paysField.getText();
					update.UpdateAdresse(numeroString, adresseString, cPString, villeString, paysString);
				}
			});
			
			centerPageCompte.add(outils.text("Adresse mail", droite, haut+340, 110, 20));
			centerPageCompte.add(tete.separator(droite, haut+360, 600, 2));
			
			centerPageCompte.add(outils.text("e-mail actuel:", droite+100, haut+390, 100, 20));
			mailField.setBounds(droite+100, haut+410, 150, 20);
			centerPageCompte.add(mailField);
			
			centerPageCompte.add(outils.text("Nouvel e-mail:", droite+100, haut+450, 130, 20));
			newMailField.setBounds(droite+100, haut+470, 150, 20);
			centerPageCompte.add(newMailField);
			
			centerPageCompte.add(outils.text("Confirmer e-mail:", droite+100, haut+510, 130, 20));
			confirmerMailField.setBounds(droite+100, haut+530, 150, 20);
			centerPageCompte.add(confirmerMailField);
			
			JButton valButton = outils.ButtonBF(255, 255, 255, "valider", droite+100, haut+570, 80, 30);
			valButton.setBorderPainted(false);
			valButton.setFocusPainted(false);
			valButton.setBackground(new Color(64, 82, 100));
			centerPageCompte.add(valButton);
			valButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					mailString=mailField.getText();
					nmailString=newMailField.getText();
					cmailString=confirmerMailField.getText();
					update.UpdateMail(mailString, nmailString, cmailString);
				}
			});

			return centerPageCompte;
	}
	public JPanel getCreateAdressePage() {
		return createAdressePage();
	}
}
