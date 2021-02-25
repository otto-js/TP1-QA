package tep1.qa.OuahbiLandier.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tp1.qa.OuahbiLandier.Programmeur;
import tp1.qa.OuahbiLandier.Programmeurs;


public class ProgrammeurMaitriseLangageTest {
	
	@Test
	public void testProgrammeurMaitriseLangageAucun() {
		Programmeurs lesProgrammeurs = creerProgrammeurs();
		
		ArrayList<Programmeur> listeAttendue = lesProgrammeurs.programmeurMaitriseLangage("aucun");

		assertEquals(listeAttendue.size(), 0);	
	}
	
	@Test
	public void testProgrammeurMaitriseLangageUn() {
		Programmeurs lesProgrammeurs = creerProgrammeurs();
		
		ArrayList<Programmeur> listeAttendue = lesProgrammeurs.programmeurMaitriseLangage("c++");
		
		assertEquals(listeAttendue.size(), 1);	
	}
	
	@Test
	public void testProgrammeurMaitriseLangageAuMoinsUn() {
		Programmeurs lesProgrammeurs = creerProgrammeurs();
		
		ArrayList<Programmeur> listeAttendue = lesProgrammeurs.programmeurMaitriseLangage("javascript");
		
		assertEquals(listeAttendue.size(), 2);	
	}

	
	
	
	public Programmeurs creerProgrammeurs() {
		
		Programmeur p1 = new Programmeur ("X", "Y", "Z");
		p1.ajouterLangage("java");
		p1.ajouterLangage("python");
		p1.ajouterLangage("javascript");
		
		Programmeur p2 = new Programmeur ("X", "Y", "Z");
		p2.ajouterLangage("Python");
		p2.ajouterLangage("SQL");
		p2.ajouterLangage("java");
		
		Programmeur p3 = new Programmeur ("X", "Y", "Z");
		p3.ajouterLangage("javascript");
		p3.ajouterLangage("c++");
		p3.ajouterLangage("React");
		
		Programmeurs lesProgrammeurs = new Programmeurs();
		lesProgrammeurs.ajouterProgrammeur(p1);
		lesProgrammeurs.ajouterProgrammeur(p2);
		lesProgrammeurs.ajouterProgrammeur(p3);
		
		return lesProgrammeurs;
	}
}



