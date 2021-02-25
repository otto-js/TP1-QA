package tp1.qa.OuahbiLandier;

import java.io.Serializable;
import java.util.ArrayList;

public class Programmeurs implements Serializable {
	
	private ArrayList<Programmeur> listeProgrammeurs;
	
	
	public Programmeurs() {
		this.listeProgrammeurs = new ArrayList<Programmeur>();
	}
	
	
	public void ajouterProgrammeur(Programmeur programmeur) {
		this.listeProgrammeurs.add(programmeur);
	}
	
	
	
	public ArrayList<Programmeur> programmeurMaitriseLangage(String langage) {

		ArrayList<Programmeur> programmeursMaitrisantLangage = new ArrayList<Programmeur>();
		
		for (int i = 0; i < listeProgrammeurs.size(); i++)
			if (listeProgrammeurs.get(i).isLangageMaitrise(langage.trim()))
				programmeursMaitrisantLangage.add(listeProgrammeurs.get(i));
		
		return programmeursMaitrisantLangage;
	}

	public ArrayList<Programmeur> getListeProgrammeurs() {
		return this.listeProgrammeurs;
	}
	
	@Override
	public String toString() {
		return "Programmeurs : " + listeProgrammeurs;
	}
	
	
}
