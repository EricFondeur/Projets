package Outils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import ConnectionBase.Personne;
import Fenetre.Connexion;

public class Tete {
	JswingCF outils = new JswingCF();
	Connexion connexion = new Connexion();
	Personne personne = new Personne();
	
	String nomString = connexion.getNom();
	String prenomString = personne.getPrenom();
	
	public JPanel enTete(String titre, int x, int y, int height, int width) {
		JPanel northJPanel =  new JPanel();
			northJPanel.setBackground(new Color(64,82,100));
			northJPanel.setLayout(null);
			JLabel titreLabel = outils.textCF(255, 255, 255, titre, 30, 15, 160, 30, 25);
			titreLabel.setHorizontalAlignment(SwingConstants.LEFT);
			northJPanel.add(titreLabel);
			northJPanel.setPreferredSize(new Dimension(0,100));
			northJPanel.add(separator(x, y, height, width));
			northJPanel.add(outils.textCF(255, 255, 255, "Bonjour,", 1400, 30, 100, 30, 25));
			northJPanel.add(outils.textCF(255, 255, 255, prenomString, 1510, 30, 200, 30, 25));
			
		return northJPanel;
	}
	
	public JSeparator separator(int x, int y, int height, int width) {
		JSeparator separator = new JSeparator();
		separator.setBounds(x, y, height, width);
		return separator;
	}
	
}
