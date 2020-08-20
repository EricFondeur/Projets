package Fenetre;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import Central.Boutique;
import Central.Commande;
import Central.Compte;
import Central.Principal;
import Central.Utilisateur;
import ConnectionBase.Personne;
import Message.Contact;
import Outils.JswingCF;
import Outils.Tete;

public class Accueil extends JFrame{
	private static final long serialVersionUID = -4939544011287453046L;

	Contact contact = new Contact();
	JPanel compteJPanel = new JPanel();
	JswingCF outils = new JswingCF();
	Tete tete = new Tete();
	String titre = "Compte";
	int haut=100;
	int droite=250;
	
	String id; 
	
	Personne personne = new Personne();
	Commande commande = new Commande();
	Principal accueil = new Principal();
	Boutique maBoutique = new Boutique();
	Compte compte = new Compte();
	Utilisateur utilisateur = new Utilisateur();
	JPanel contentPane =  (JPanel) this.getContentPane();
	int MousepX;
	int MousepY;
	JPanel menuJPanel =  new JPanel(new BorderLayout());
	JPanel LeftMenuJPanel =  new JPanel();
	JToolBar toolBar = new JToolBar();
	JLayeredPane layeredPane = new JLayeredPane();
	String roleString="administrateur";
	
		JPanel AccueilPanel = new JPanel();
		JPanel boutiquePanel = new JPanel();
		JPanel commandePanel = new JPanel();
		JPanel comptePanel = new JPanel();
		JPanel utilisateurPanel = new JPanel();
	
	public Accueil()  {
		/* construction de l'interface graphique*/
	
		super( "Ma premier application swing" );
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setResizable(false);
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.setMaximizedBounds(env.getMaximumWindowBounds());
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		/* construction et injection du contenu*/
		contentPane.add(createNorthPanel(), BorderLayout.NORTH);
		contentPane.add(createLeftPanel(), BorderLayout.WEST);
		contentPane.add(createToolBarContact(), BorderLayout.SOUTH);
		contentPane.add(centerPanel(), BorderLayout.CENTER);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				int clickeButton = JOptionPane.showConfirmDialog(Accueil.this, 
						"Etes vous sur de vouloir quittez ?", "Title", JOptionPane.YES_NO_OPTION);
				if (clickeButton == JOptionPane.YES_OPTION) {
					Accueil.this.dispose();
				}
			}
		});
	}	
	
	
	// Center page
	public JLayeredPane centerPanel() {

		getContentPane().add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.add(createAccueil());
		layeredPane.add(createBoutique());
		layeredPane.add(createCommande());
		layeredPane.add(createCompte());
		layeredPane.add(createUtilisateur());
		return layeredPane;
	}
	
	//PARTIE CENTRAL //	
	// En tête page inscrit
	private JPanel createNorthPanel() {
		
		menuJPanel.setBackground(new Color(51,51,51));
		menuJPanel.setPreferredSize(new Dimension(0,35));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(new Color(51,51,51));
		menuJPanel.add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new BorderLayout(10, 100));
		
		JButton reduirBoutton = new JButton();
		reduirBoutton.setIcon(new ImageIcon("src/images/reduire.png"));
		reduirBoutton.setBackground(new Color(51,51,51));
		reduirBoutton.setPreferredSize(new Dimension(35,35));
		reduirBoutton.setBorderPainted(false);
		reduirBoutton.setFocusPainted(false);
		reduirBoutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {
				reduirBoutton.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent arg0) {
				reduirBoutton.setBackground(new Color(51,51,51));
			}
		});
		reduirBoutton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		reduirBoutton.setForeground(Color.WHITE);
		rightPanel.add(reduirBoutton, BorderLayout.WEST);
		
		
		JButton maximizeButton = new JButton();
		maximizeButton.setIcon(new ImageIcon("src/images/maximize.png"));
		maximizeButton.setBackground(new Color(51,51,51));
		maximizeButton.setPreferredSize(new Dimension(35,35));
		maximizeButton.setBorderPainted(false);
		maximizeButton.setFocusPainted(false);
		maximizeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
			public void mouseEntered(MouseEvent arg0) {
				maximizeButton.setBackground(Color.LIGHT_GRAY);
			}
			public void mouseExited(MouseEvent arg0) {
				maximizeButton.setBackground(new Color(51,51,51));
			}
		});
		rightPanel.add(maximizeButton, BorderLayout.CENTER);
		
		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("src/images/close.png"));
		closeButton.setBackground(new Color(51,51,51));
		closeButton.setPreferredSize(new Dimension(35,35));
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
		closeButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent arg0) {
				closeButton.setBackground(Color.RED);
			}
			public void mouseExited(MouseEvent arg0) {
				closeButton.setBackground(new Color(51,51,51));
			}
		});
		rightPanel.add(closeButton, BorderLayout.EAST);
		return menuJPanel;
	}
	
	// Menu
	private JPanel createLeftPanel() {
		LeftMenuJPanel.setBackground(new Color(44,62,80));
		LeftMenuJPanel.setPreferredSize(new Dimension(200,0));
		LeftMenuJPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel North = new JPanel();
		LeftMenuJPanel.add(North, BorderLayout.NORTH);
		North.setBackground(new Color(44, 62, 80));
		North.setPreferredSize(new Dimension(0,100));
			North.setLayout(new GridLayout(2, 1));
			JLabel lblTitreApplication = new JLabel("Sport Y Shop");
			lblTitreApplication.setVerticalAlignment(SwingConstants.BOTTOM);
			lblTitreApplication.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitreApplication.setForeground(Color.WHITE);
			lblTitreApplication.setFont(new Font("Modern No. 20", Font.PLAIN, 25));
			North.add(lblTitreApplication);
			
			JSeparator separator = new JSeparator();
			North.add(separator);
		

		JPanel Center = new JPanel();
		LeftMenuJPanel.add(Center, BorderLayout.CENTER);
		Center.setBackground(new Color(44, 62, 80));
			Center.setLayout(new BorderLayout(0, 0));
			
			JPanel centerMenu = new JPanel();
			centerMenu.setBackground(new Color(44,62,80));
			Center.add(centerMenu, BorderLayout.CENTER);
			centerMenu.setLayout(new GridLayout(16,1));
			
			JButton ACbuton = new JButton("Accueil");
			centerMenu.add(ACbuton);
			ACbuton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			ACbuton.setBackground(new Color(44, 62, 80));
			ACbuton.setBorderPainted(false);
			ACbuton.setFocusPainted(false);
			ACbuton.setForeground(Color.WHITE);
			ACbuton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanels(AccueilPanel);
				}
				
			});
			mouseEntSort(ACbuton);
			
			JButton BQbuton = new JButton("Boutique");
			centerMenu.add(BQbuton);
			BQbuton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			BQbuton.setBackground(new Color(44, 62, 80));
			BQbuton.setBorderPainted(false);
			BQbuton.setFocusPainted(false);
			BQbuton.setForeground(Color.WHITE);
			BQbuton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					switchPanels(boutiquePanel);
					maBoutique.updateTable();
				}
			});
			mouseEntSort(BQbuton);
			
			JButton CMDbuton = new JButton("Commande");
			centerMenu.add(CMDbuton);
			CMDbuton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			CMDbuton.setBackground(new Color(44, 62, 80));
			CMDbuton.setBorderPainted(false);
			CMDbuton.setFocusPainted(false);
			CMDbuton.setForeground(Color.WHITE);
			CMDbuton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanels(commandePanel);
					commande.updateTable();
				}
			});
			mouseEntSort(CMDbuton);
			
			JButton CPButton = new JButton("Compte");
			centerMenu.add(CPButton);
			CPButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			CPButton.setBackground(new Color(44, 62, 80));
			CPButton.setBorderPainted(false);
			CPButton.setFocusPainted(false);
			CPButton.setForeground(Color.WHITE);
			CPButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanels(comptePanel);
					
				}
			});
			mouseEntSort(CPButton);
			
			JPanel southMenu = new JPanel();
			southMenu.setBackground(new Color(44,62,80));
			Center.add(southMenu, BorderLayout.SOUTH);
			southMenu.setLayout(new BorderLayout(0, 0));
			
			JButton DcoButton = new JButton("Deconnexion");
			DcoButton.setBackground(new Color(44,62,80));
			DcoButton.setForeground(Color.WHITE);
			DcoButton.setHorizontalAlignment(SwingConstants.LEFT);
			southMenu.add(DcoButton, BorderLayout.CENTER);
			DcoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Connexion connexion = new Connexion();
					dispose();
					connexion.setVisible(true);
					connexion.setLocationRelativeTo(null);
					connexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			});
	
			JButton utilButton = new JButton("Utilisateurs");
			centerMenu.add(utilButton);
			utilButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
			utilButton.setBackground(new Color(44, 62, 80));
			utilButton.setBorderPainted(false);
			utilButton.setFocusPainted(false);
			utilButton.setForeground(Color.WHITE);
			utilButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanels(utilisateurPanel);
					utilisateur.updateTable();
				}
			});
			if (personne.GetRole().equals("utilisateur")) {
				utilButton.setVisible(false);
			}

		return LeftMenuJPanel;
	}
	
	// Contact
	// ToolBar
	private JToolBar createToolBarContact() {
		
		JButton ISCbutton = new JButton("Contact");
		toolBar.add(ISCbutton);
		ISCbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				contact.setVisible(true);
			}
		});
		
		return toolBar;
	}
	
	// Boutique
	
	// Import des parties central
	private JPanel createAccueil(){
		return AccueilPanel = accueil.getCreateAccueil();
	}
	
	private JPanel createBoutique() {
		return boutiquePanel = maBoutique.getCreateBoutique();
	}
	
	private JPanel createCommande()  {
		return commandePanel = commande.getCreateCommande(); 
	}
	
	private JPanel createCompte() {
		return comptePanel = compte.getCreateCompte();
	}
	
	private JPanel createUtilisateur() {
		return utilisateurPanel = utilisateur.getCreateUtilisateur();
	}
	// Methode pour changer la partie central
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	// methode changer color boutton
	private void mouseEntSort(JButton button) {
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				button.setBackground(new Color(64,82,100));
			}
			public void mouseExited(MouseEvent arg0) {
				button.setBackground(new Color(44,62,80));
			}
		});
	}
	public String getId () {
		return id;
	}
}
