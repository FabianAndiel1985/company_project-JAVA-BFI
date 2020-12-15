package at.bfi.oop.aufgabe.firmaprojekt.model;

import java.util.ArrayList;
import java.util.List;

public class Firma {
	
	public static String firmen_name;
	
	private List<Abteilung> abteilungs_liste = new ArrayList<Abteilung>();
	
	private List<Mitarbeiter> mitarbeiter_liste = new ArrayList<Mitarbeiter>();

	public Firma(List<Abteilung> abteilungs_liste) {
		this.abteilungs_liste = abteilungs_liste;
	}

	public Firma(List<Abteilung> abteilungs_liste, List<Mitarbeiter> mitarbeiter_liste) {
		this.abteilungs_liste = abteilungs_liste;
		this.mitarbeiter_liste = mitarbeiter_liste;
	}


	public List<Abteilung> getAbteilungs_liste() {
		return abteilungs_liste;
	}

	public void setAbteilungs_liste(List<Abteilung> abteilungs_liste) {
		this.abteilungs_liste = abteilungs_liste;
	}

	public List<Mitarbeiter> getMitarbeiter_liste() {
		return mitarbeiter_liste;
	}

	public void setMitarbeiter_liste(List<Mitarbeiter> mitarbeiter_liste) {
		this.mitarbeiter_liste = mitarbeiter_liste;
	}


	
	
	

}
