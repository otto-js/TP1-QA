package tep1.qa.OuahbiLandier.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tp1.qa.OuahbiLandier.Programmeur;

public class IsLangageMaitriseTest {

	@Test
	public void testIsLangageMaitriseVrai() {

		Programmeur p = creerProgrammeur();
		
		boolean resultatRecu = p.isLangageMaitrise("java");
		assertTrue(resultatRecu);		
	}
	
	@Test
	public void testIsLangageMaitriseFaux() {
		
		Programmeur p = creerProgrammeur();
		
		boolean resultatRecu = p.isLangageMaitrise("jav");
		assertFalse(resultatRecu);		
	}
	
	@Test //vérifie que les espaces sont bien enlevés au string fourni
	public void testIsLangageMaitriseTrim() {
		
		Programmeur p = creerProgrammeur();
		
		boolean resultatRecu = p.isLangageMaitrise("  java  ");
		assertTrue(resultatRecu);		
	}

	@Test //vérifie que la casse n'est pas considérée
	public void testIsLangageMaitriseCase() {
		
		Programmeur p = creerProgrammeur();
		
		boolean resultatRecu = p.isLangageMaitrise("JavA");
		assertTrue(resultatRecu);		
	}
	
	public Programmeur creerProgrammeur() {
		Programmeur p = new Programmeur ("X", "Y", "Z");
		p.ajouterLangage("java");
		p.ajouterLangage("python");
		p.ajouterLangage("javascript");
		
		return p;
	}
	
}
