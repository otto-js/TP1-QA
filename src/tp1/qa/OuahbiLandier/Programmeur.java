package tp1.qa.OuahbiLandier;

import java.io.Serializable;
import java.util.ArrayList;


public class Programmeur implements Serializable {

	private String nom, prenom, courriel;
	private ArrayList<String> langages;
	
	
	public Programmeur(String nom, String prenom, String courriel) {
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.langages = new ArrayList<String>();
	}

	public void ajouterLangage(String langage) {
		this.langages.add(langage.trim().toLowerCase());
	}
	
	
	public boolean isLangageMaitrise(String langage) {
		for (int i = 0; i < langages.size(); i++)
			if (langages.get(i).equalsIgnoreCase(langage.trim()))
			{
				return true;
			}
		return false;
	}
	
	public ArrayList<String> getLangage() {
		return this.langages;
	}
	
	@Override
	public String toString() {
		return "\nNom: " + this.nom + 
			"\nPrénom: " + this.prenom +
			"\nCourriel: " + this.courriel +
			"\nLangages maîtrisés: " + langages +
			"\n";
	}

	public ArrayList<String> getLangages(){
		return this.langages;
	}
	
}
