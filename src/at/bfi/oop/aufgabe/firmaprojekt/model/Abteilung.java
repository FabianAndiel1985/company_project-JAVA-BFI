package at.bfi.oop.aufgabe.firmaprojekt.model;

import java.util.ArrayList;
import java.util.List;

public class Abteilung {

	
	protected int id;
	protected String abteilungsname;
	protected String abteilungs_leiter;
	public List<Mitarbeiter> mitarb_list = new ArrayList<Mitarbeiter>();
	
	
	public Abteilung() {
		
	}
	
	public Abteilung(int id) {
		this.id = id;
		
	}
	
	public Abteilung(int id, String abteilungsname) {
		this.id = id;
		this.abteilungsname = abteilungsname;
		
	}
	
	public Abteilung (int id, String abteilungsname, String abteilungs_leiter) {
		this.id = id;
		this.abteilungsname = abteilungsname;
		this.abteilungs_leiter = abteilungs_leiter;
		
		
	}
	
	public Abteilung (int id, String abteilungsname, String abteilungs_leiter, List<Mitarbeiter> mitarbeiter_liste) {
		this.id = id;
		this.abteilungsname = abteilungsname;
		this.abteilungs_leiter = abteilungs_leiter;
		this.setMitarb_list(mitarbeiter_liste);
		
	}
	
	

	@Override
	public String toString() {
		
		return "ID: " + getId() + ", Abteilungsname: " + getAbteilungsname() + ", Abteilungsleiter: " + getAbteilungs_leiter() + ", Anzahl der Mitarbeiter: " + getMitarb_list().size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbteilungsname() {
		return abteilungsname;
	}

	public void setAbteilungsname(String abteilungsname) {
		this.abteilungsname = abteilungsname;
	}

	public String getAbteilungs_leiter() {
		return abteilungs_leiter;
	}

	public void setAbteilungs_leiter(String abteilungs_leiter) {
		this.abteilungs_leiter = abteilungs_leiter;
	}

	public List<Mitarbeiter> getMitarb_list() {
		return mitarb_list;
	}

	public void setMitarb_list(List<Mitarbeiter> mitarb_list) {
		this.mitarb_list.addAll(mitarb_list);
	}

	
	
	
}
