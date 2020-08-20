package Compte;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ConnectionBase.Personne;
import Outils.JswingCF;
import Outils.Tete;
import SQL.Update;

public class Details {
	Update update = new Update();
	Personne sql = new Personne();
	JswingCF outils = new JswingCF();
	Tete tete = new Tete();
	int haut=70;
	int droite=250;
	
	String nomString=sql.getNom();
	String prenomString=sql.getPrenom();
	String dateNaiss=sql.getDateNaiss();
	String telString=sql.getTelephone();
	String MDP="";
	String NMDP="";
	String CMDP="";
	
	JTextField nomField = new JTextField(nomString);
	JTextField prenomField = new JTextField(prenomString);
	JTextField dateNaissField = new JTextField(dateNaiss);
	JTextField telField = new JTextField(telString);
	JPasswordField MDPField = new JPasswordField();
	JPasswordField nMDPField = new JPasswordField();
	JPasswordField cMDField = new JPasswordField();
	
	private JPanel createCenterComptePanel() {		
		JPanel centerPageCompte = new JPanel();
		centerPageCompte.setBackground(Color.WHITE);
		centerPageCompte.setLayout(null);
			centerPageCompte.add(outils.textCF("Details", droite, haut, 100, 40, 22));
			
			centerPageCompte.add(outils.text("Mes informations", droite, haut+50, 110, 20));
			centerPageCompte.add(tete.separator(droite, haut+70, 600, 2));
			
			centerPageCompte.add(outils.text("Nom :", droite+100, haut+100, 40, 20));
			nomField.setBounds(droite+100, haut+120, 150, 20);
			centerPageCompte.add(nomField);
			
			centerPageCompte.add(outils.text("Prenom :", droite+300, haut+100, 60, 20));
			prenomField.setBounds(droite+300, haut+120, 150, 20);
			centerPageCompte.add(prenomField);
			
			centerPageCompte.add(outils.text("date de naissance :", droite+100, haut+160, 130, 20));
			dateNaissField.setBounds(droite+100, haut+180, 150, 20);
			centerPageCompte.add(dateNaissField);
			
			centerPageCompte.add(outils.text("numero de telephone :", droite+100, haut+220, 130, 20));
			telField.setBounds(droite+100, haut+240, 150, 20);
			centerPageCompte.add(telField);
			
			JButton saveButton=outils.ButtonBF(255, 255, 255, "valider", droite+100, haut+280, 80, 30);
			saveButton.setBorderPainted(false);
			saveButton.setFocusPainted(false);
			saveButton.setBackground(new Color(64,82,100));
			centerPageCompte.add(saveButton);
			saveButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					nomString=nomField.getText();
					prenomString=prenomField.getText();
					telString=telField.getText();
					dateNaiss=dateNaissField.getText();
					update.UpdateDetails(nomString, prenomString, telString, dateNaiss);
				}
			});
			
			centerPageCompte.add(outils.text("Mot de passe", droite, haut+340, 110, 20));
			centerPageCompte.add(tete.separator(droite, haut+360, 600, 2));
			
			centerPageCompte.add(outils.text("mot de passe actuel:", droite+100, haut+390, 150, 20));
			MDPField.setBounds(droite+100, haut+410, 130, 20);
			centerPageCompte.add(MDPField);
			
			centerPageCompte.add(outils.text("nouveau mot de passe:", droite+100, haut+450, 150, 20));
			nMDPField.setBounds(droite+100, haut+470, 130, 20);
			centerPageCompte.add(nMDPField);
			
			centerPageCompte.add(outils.text("Confirmer le mot de passe", droite+100, haut+510, 200, 20));
			cMDField.setBounds(droite+100, haut+530, 130, 20);
			centerPageCompte.add(cMDField);
			
			JButton valButton = outils.ButtonBF(255, 255, 255, "valider", droite+100, haut+570, 80, 30);
			valButton.setBorderPainted(false);
			valButton.setFocusPainted(false);
			valButton.setBackground(new Color(64, 82, 100));
			centerPageCompte.add(valButton);
			valButton.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (NMDP.equals("")) {
						JOptionPane.showMessageDialog(null, "rentrez un mot de passe");
					}
					else {
						MDP=new String(MDPField.getPassword());
						NMDP=new String(nMDPField.getPassword());
						CMDP=new String(cMDField.getPassword());
						update.UpdateMDP(MDP, NMDP, CMDP);
					}
				}
			});
			return centerPageCompte;
	}
	
	public JPanel getCreateCenterCompte() {
		return createCenterComptePanel();
	}
}
