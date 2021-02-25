package tp1.qa.OuahbiLandier;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

import tp1.qa.OuahbiLandier.util.Util;

public class Programme{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		String fichierOuvert = "";
		int bouton;
		Programmeurs listeProgrammeurs = new Programmeurs();
		char choix;
		
		choix = afficherMenu();
		
		while (choix != 'q') {
			switch (choix) {
				case 'a': 
					
					System.out.print("Prénom : ");
					String prenom = sc.nextLine();
				
					System.out.print("Nom : ");
					String nom = sc.nextLine();
				
					System.out.print("Courriel : ");
					String courriel = sc.nextLine();
					
					Programmeur p = new Programmeur(nom, prenom, courriel);
					int compteur = 1;
					System.out.println(" --- Langage maîtrisés ---");
					System.out.println(" ---   0 pour sortir   ---");
					
					String langage = "";
						do { 
							System.out.print("Langage " + compteur + " : ");
							langage = sc.nextLine();
							if (langage.length() != 0) {
								if (langage.charAt(0) != '0') {
									p.ajouterLangage(langage);
									compteur++;
								}
							} else {
								System.out.println("Veuillez entre un langage ou sortir avec 0");
								langage = " ";
							}
							
						}while (langage.charAt(0) != '0');
						
					listeProgrammeurs.ajouterProgrammeur(p);
					System.out.println("\nProgrammeur ajouté à la liste");
					break;
					
				case 'd': 
						if (listeProgrammeurs.getListeProgrammeurs().size() > 0)
							System.out.println(listeProgrammeurs);
						else
							System.out.println("\nAucun programmeurs dans la liste");
					break;
					
				case 'e': 
						if (listeProgrammeurs.getListeProgrammeurs().size() > 0) {
							JFileChooser boiteChoixFichierSauvegarde = new JFileChooser();
							bouton = boiteChoixFichierSauvegarde.showSaveDialog(null);
							if (JFileChooser.APPROVE_OPTION == bouton) {
								fichierOuvert = boiteChoixFichierSauvegarde.getSelectedFile().getPath();
								Util.sauvegarderObjet(listeProgrammeurs, fichierOuvert);
								System.out.println("\nObjets sauvegardés");
							}
						} else {
							System.out.println("\nAucun programmeurs à enregistrer");
						}
					
					break;
					
				case 'o': 
					JFileChooser boiteChoixFichierOuvrir= new JFileChooser();
					bouton = boiteChoixFichierOuvrir.showOpenDialog(null);
					if (JFileChooser.APPROVE_OPTION == bouton) {
						fichierOuvert = boiteChoixFichierOuvrir.getSelectedFile().getPath();
						listeProgrammeurs = Util.ouvrirObjet(fichierOuvert);
						System.out.println("Programmeurs chargés");
					}
				
					break;
					
				case 'c': 
					JFileChooser boiteChoixFichierOuvrirCSV= new JFileChooser();
					bouton = boiteChoixFichierOuvrirCSV.showOpenDialog(null);	
					if (JFileChooser.APPROVE_OPTION == bouton) {
						fichierOuvert = boiteChoixFichierOuvrirCSV.getSelectedFile().getPath();
						listeProgrammeurs = Util.lireFichierCSV(fichierOuvert);
						System.out.println("Programmeurs chargés");
					}
				
					break;
				
				case 'j': 
					JFileChooser boiteChoixFichierSauveJson= new JFileChooser();
					bouton = boiteChoixFichierSauveJson.showSaveDialog(null);
					fichierOuvert = boiteChoixFichierSauveJson.getSelectedFile().getPath();
					if (JFileChooser.APPROVE_OPTION == bouton) {
						Util.creerFichierJSON(fichierOuvert, listeProgrammeurs);
						System.out.println("Fichier sauvegardé");
					}
					break;
					
				case 'p': 
						System.out.println("Langage à chercher : ");
						langage = sc.nextLine();
						ArrayList<Programmeur>  listeProg = listeProgrammeurs.programmeurMaitriseLangage(langage);
						if (listeProg.size() > 0)
						System.out.println(listeProg);
						else
							System.out.println("Aucun programmeur de votre liste ne maîtrise " + langage + ".");
					break;
					
					
				default : System.out.println("Option inconnue");
			}
			
		choix = afficherMenu();
		}
		System.out.println("Merci d'avoir utilisé le gestionnaire de programmeurs");
	}
	
	public static char afficherMenu() {
		String s = " ";
		char c = ' ';
		
		System.out.println("\n ---- Bienvenue dans votre gestion de programmeurs ---- ");
		
		System.out.println("a : Ajouter un nouveau programmeur");
		System.out.println("d : Afficher la liste des programmeurs");
		System.out.println("e : Enregistrer vos programmeurs");
		System.out.println("o : Ouvrir vos programmeurs sauvegardés");
		System.out.println("c : Ouvrir un fichier CSV");
		System.out.println("j : Sauvegarder en format JSON");
		System.out.println("p : Programmeurs maîtrisant un langage");
		System.out.println("q : Quitter");
		
		System.out.print("Veuillez sélectionner une option : ");
		
		s = sc.nextLine();
		
		if (s.length() > 0)
			c = s.charAt(0);
		
		return c;
	}
}
	

	
	
	
	
	
	
	