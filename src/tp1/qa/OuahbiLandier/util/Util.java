package tp1.qa.OuahbiLandier.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import com.google.gson.Gson;
import tp1.qa.OuahbiLandier.Programmeur;
import tp1.qa.OuahbiLandier.Programmeurs;

public class Util {
	
	public static boolean sauvegarderObjet(Programmeurs programmeurs, String nomFichier)  {
		
		try (
			FileOutputStream fichierCree = new FileOutputStream(nomFichier, true);
			ObjectOutputStream objetSortie = new ObjectOutputStream(fichierCree);
				)
		{
			objetSortie.writeObject(programmeurs);
			return true;
			
		} catch (IOException e) {
			System.out.println("Un problème avec l'écriture en fichier est survenu");
		}
		return false;
	}
	
	
	public static Programmeurs ouvrirObjet(String nomFichier) {
		Programmeurs objetCharge = new Programmeurs();
		
		try (
			FileInputStream fichierLu = new FileInputStream(nomFichier);
			ObjectInputStream objetCree = new ObjectInputStream(fichierLu);			
		)
		{
			
		Object liste = objetCree.readObject();
		
		if (liste instanceof Programmeurs)
			objetCharge = (Programmeurs)liste;
		
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Un problème avec la lecture du fichier est survenu");
		}
		return objetCharge;	
	}

	
	public static Programmeurs lireFichierCSV(String fichierCSV) {
	
		Programmeurs listeProgrammeurs = new Programmeurs();

		
		try {
			FileReader f = new FileReader(fichierCSV);
			BufferedReader lecteur = new BufferedReader(f);
			
			//passage des deux premières lignes d'entête du fichier csv
			lecteur.readLine();
			lecteur.readLine();
			
			String ligne = "";
			
			while((ligne = lecteur.readLine()) != null) {
				 String[] s = ligne.split(";");
				 String courriel = s[0];
				 String nom = s[1];
				 String prenom = s[2];
				 Programmeur p = new Programmeur(nom, prenom, courriel);
				 for (int i = 3; i < s.length; i++)
					 p.ajouterLangage(s[i]);
					 
				listeProgrammeurs.ajouterProgrammeur(p);
			}
			
			lecteur.close();
		
		} catch (IOException e) {
			System.out.println("Un problème de lecture est survenu");
		}
		return listeProgrammeurs;
	}

	 
	public static void creerFichierJSON(String nomFichierDestination, Programmeurs listeProgrammeurs) { 
		   try(
				   PrintWriter pw = new PrintWriter(nomFichierDestination);
		      )
		   { 
	            Gson g = new Gson();            
	            pw.println(g.toJson(listeProgrammeurs));
	            
		   } catch (FileNotFoundException e) {
			   System.out.println("Le fichier spécifié n'a pas été trouvé");
		   }
	}
	       
	    
	    
	
}
