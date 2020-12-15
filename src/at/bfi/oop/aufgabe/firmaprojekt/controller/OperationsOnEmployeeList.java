package at.bfi.oop.aufgabe.firmaprojekt.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import at.bfi.oop.aufgabe.firmaprojekt.model.Abteilung;
import at.bfi.oop.aufgabe.firmaprojekt.model.Angestellter;
import at.bfi.oop.aufgabe.firmaprojekt.model.Arbeiter;
import at.bfi.oop.aufgabe.firmaprojekt.model.Firma;
import at.bfi.oop.aufgabe.firmaprojekt.model.Mitarbeiter;
import at.bfi.oop.aufgabe.firmaprojekt.model.VerwaltungInterface;

public class OperationsOnEmployeeList implements VerwaltungInterface{

	

	private List<Mitarbeiter> mitarbeiter_liste = new ArrayList<Mitarbeiter>(SIZE_MITARB_LIST);

	private List<Abteilung> abteilungs_liste = new ArrayList<Abteilung>(SIZE_ABT_LIST);
	
	private Firma firma;
	
	
	public OperationsOnEmployeeList() {
		init();
	}
	
	
	public static void main(String[] args) {

		
		OperationsOnEmployeeList verwaltung = new OperationsOnEmployeeList();
//		System.out.println(verwaltung.mitarbeiter_suche(5));
//		verwaltung.ausgabeMitarbeiterListe(verwaltung.mitarbeiter_liste);
//		verwaltung.berechneSummeAllerGehaelter(verwaltung.mitarbeiter_liste);
//		System.out.println(Angestellter.counter);
//		verwaltung.ausgabeAllerAbteilungen();
//		System.out.println(verwaltung.searchAbteilung(2));
//		verwaltung.ausgabeMitarbeiterListe(verwaltung.getMitarbeiterListeVonAbteilung(3));
//		System.out.println(verwaltung.searchMitarbeiterAusAlleAbteilungen(5));
		verwaltung.sortMitarbeiterNachGehalt();
//		verwaltung.sortMitarbeiterNachNamen();
	}
	
	// Search for a Worker with certain ID
	private  Mitarbeiter mitarbeiter_suche(int id) {

		Mitarbeiter mitarb_search = null;
		
		for (Mitarbeiter mitarbeiter : mitarbeiter_liste) {
			if (mitarbeiter.getId() == id)
				mitarb_search = mitarbeiter;
		}
		return mitarb_search;
	}

	// Output for the data of a worker
	private  void ausgabeMitarbeiter(Mitarbeiter mitarbeiter) {

		System.out.println("==========Mitarbeiter Ausgabe:==========");
		System.out.println(mitarbeiter.toString());
	}

	// Output for the whole worker list
	private void ausgabeMitarbeiterListe(List<Mitarbeiter> list) {

		System.out.println("==========Mitarbeiter Liste Ausgabe:==========");
		
		for (Mitarbeiter mitarbeiter : list) {
			System.out.println(mitarbeiter.toString());
		}
	}
	
	private void ausgabeMitarbeiterListe() {
		
System.out.println("==========Mitarbeiter Liste Ausgabe:==========");
		
		for (Mitarbeiter mitarbeiter : this.mitarbeiter_liste) {
			System.out.println(mitarbeiter.toString());
		}
	}

	// Output for the list of sections
	private void ausgabeAllerAbteilungen() {
		
		for (Abteilung abteilung : abteilungs_liste) {
			System.out.println(abteilung.toString());
		}	
	}

	// Search if there is a certain section
	private boolean searchAbteilung(int id) {
		
		for (Abteilung abteilung : abteilungs_liste) {
			if (abteilung.getId() == id)
				return true;
		}
		return false;	
	}
	
	// Output for the list of workers of a section
	private List<Mitarbeiter> getMitarbeiterListeVonAbteilung(int abt_id) {
		
		for (Abteilung abteilung : abteilungs_liste) {
			if (abteilung.getId() == abt_id)
				return abteilung.getMitarb_list();
		}
		return null;
	}
	
	//search for a worker in all the sections
	private Mitarbeiter searchMitarbeiterAusAlleAbteilungen (int mitarbeiter_id) {
		
	for (Abteilung abteilung : abteilungs_liste) {
		for (Mitarbeiter mitarbeiter : abteilung.mitarb_list) {
			if( mitarbeiter.getId() == mitarbeiter_id)
				return mitarbeiter;
		}	
	}
	return null;
	}

	// Calculation of all the brutto salary
		private void berechneSummeAllerGehaelter(List<Mitarbeiter> mitarbeiter) {

			double gehaelter_gesamt = 0;

			for (Mitarbeiter mitarbeiter2 : mitarbeiter) {
				gehaelter_gesamt = mitarbeiter2.berechneBrutto() + gehaelter_gesamt;
			}
			System.out.println("Summe aller Brutto Gehälter: " + String.format("%1.2f €",gehaelter_gesamt));
		}

		
		// sort of workers depending on their salary
		private void sortMitarbeiterNachGehalt() {
			System.out.println("==========sortMitarbeiternNachGehalt==========");
			
			//that one works
//			this.mitarbeiter_liste.sort(new Comparator<Mitarbeiter>() {
//
//				@Override
//				public int compare(Mitarbeiter o1, Mitarbeiter o2) {
//					
//					if(o1.getBrutto() < o2.getBrutto())
//						return -1;
//					else if (o1.getBrutto() > o2.getBrutto())
//						return 1;
//					else
//						return 0;
//				}
//				
//				
//			});
//			ausgabeMitarbeiterListe();
//			
			// that one doesnt
//			this.mitarbeiter_liste.
//			stream().
//				sorted((Mitarbeiter m1, Mitarbeiter m2) -> (m1.getBrutto() == m2.getBrutto())).forEach(e -> System.out.println(e));

			this.mitarbeiter_liste.stream().sorted(Comparator.comparing(Mitarbeiter -> Mitarbeiter.getBrutto()))
					.collect(Collectors.toList());
			
			ausgabeMitarbeiterListe();
		}
		
		// sort all workers depending on their name
		private void sortMitarbeiterNachNamen() {
			
			System.out.println("==========sortMitarbeiternNachName==========");
			
//			1. Möglichkeit : Methode mit annonymer Comparator Klasse
			
//			this.mitarbeiter_liste.sort(new Comparator<Mitarbeiter>() {
//
//				@Override
//				public int compare(Mitarbeiter o1, Mitarbeiter o2) {
//						return o1.getName().compareTo(o2.getName());
//				}
//				
//			
//			});
//			ausgabeMitarbeiterListe();
//			
			
// 			2. Möglichkeit : Lambda interface mit annonymer Comparator Klasse
//			this.getMitarbeiter_liste().sort((Mitarbeiter m1, Mitarbeiter m2) -> m1.getName().compareTo(m2.getName()));
//			ausgabeMitarbeiterListe();
//			
//			
//			// Zur ausgabe der ganzen Mitarbeiter Liste, man erspart sich eine ganze methode ausgabeMitarbeiterListe
//			this.mitarbeiter_liste.forEach(e -> System.out.println(e));
//			
//			
			//3. Möglichkeit mit Stream
			this.mitarbeiter_liste.
						stream().
							sorted((Mitarbeiter m1, Mitarbeiter m2) -> m1.getName().compareTo(m2.getName())).forEach(e -> System.out.println(e));

		}
		
	// initialising of the section lists and the worker lists
	private void init() {
		
		// worker list
		
		this.mitarbeiter_liste.add(new Angestellter(1,"a1",1000,200)); 
		this.mitarbeiter_liste.add(new Angestellter(2,"a2",1001,201)); 
		this.mitarbeiter_liste.add(new Angestellter(3,"a3",1002,202)); 
		this.mitarbeiter_liste.add(new Angestellter(4,"a4",1003,203)); 
		this.mitarbeiter_liste.add(new Angestellter(5,"a5",1004,204)); 
		this.mitarbeiter_liste.add(new Angestellter(6,"a6",1005,205)); 
		
		this.mitarbeiter_liste.add(new Arbeiter(7,"b1",1000,4,200)); 
		this.mitarbeiter_liste.add(new Arbeiter(8,"b2",1001,6,201)); 
		this.mitarbeiter_liste.add(new Arbeiter(9,"b3",1002,8,202)); 
		this.mitarbeiter_liste.add(new Arbeiter(10,"b4",1003,10,203)); 
		this.mitarbeiter_liste.add(new Arbeiter(11,"b5",1004,14,204)); 
		this.mitarbeiter_liste.add(new Arbeiter(12,"b6",1005,19,205));
		
	
		
		//PR worker list
		
		List<Mitarbeiter> mitarbeiter_PR = new ArrayList<Mitarbeiter>();
		mitarbeiter_PR.add(mitarbeiter_suche(1));
		mitarbeiter_PR.add(mitarbeiter_suche(6));
		mitarbeiter_PR.add(mitarbeiter_suche(7));
		mitarbeiter_PR.add(mitarbeiter_suche(8));
		
		
		
		// SALES worker list
		
		List<Mitarbeiter> mitarbeiter_SALES = new ArrayList<Mitarbeiter>();
		mitarbeiter_SALES.add(mitarbeiter_suche(2));
		mitarbeiter_SALES.add(mitarbeiter_suche(3));
		mitarbeiter_SALES.add(mitarbeiter_suche(9));
		mitarbeiter_SALES.add(mitarbeiter_suche(10));
		mitarbeiter_SALES.add(mitarbeiter_suche(11));
		
		//IT worker list

		List<Mitarbeiter> mitarbeiter_IT = new ArrayList<Mitarbeiter>();
		mitarbeiter_IT.add(mitarbeiter_suche(5));
		mitarbeiter_IT.add(mitarbeiter_suche(6));
		mitarbeiter_IT.add(mitarbeiter_suche(12));
		
		
		//HR worker list
	
		List<Mitarbeiter> mitarbeiter_HR = new ArrayList<Mitarbeiter>();
		mitarbeiter_HR.add(mitarbeiter_suche(4));
		
		
		
		//sections
		
		abteilungs_liste.add(new Abteilung(1, "PR", null, mitarbeiter_PR));
		abteilungs_liste.add(new Abteilung(2, "SALES", null, mitarbeiter_SALES));
		abteilungs_liste.add(new Abteilung(3, "IT", null, mitarbeiter_IT));
		abteilungs_liste.add(new Abteilung(4, "HR", null, mitarbeiter_HR));
		
	
		//company

		Firma firma = new Firma(abteilungs_liste, mitarbeiter_liste);
		firma.firmen_name = "bfi";
		
	}


	//getters and setters

	public List<Mitarbeiter> getMitarbeiter_liste() {
		return mitarbeiter_liste;
	}


	public void setMitarbeiter_liste(List<Mitarbeiter> mitarbeiter_liste) {
		this.mitarbeiter_liste = mitarbeiter_liste;
	}


	public List<Abteilung> getAbteilungs_liste() {
		return abteilungs_liste;
	}


	public void setAbteilungs_liste(List<Abteilung> abteilungs_liste) {
		this.abteilungs_liste = abteilungs_liste;
	}


	public Firma getFirma() {
		return firma;
	}


	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	
}
