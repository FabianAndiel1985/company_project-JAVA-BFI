package at.bfi.oop.aufgabe.firmaprojekt.model;

public class Arbeiter extends Mitarbeiter {

	
	//Attributes
	protected double stundenlohn;
	protected double anz_stunden;
	protected double schicht_Zulage;
	// tax in percentage
	protected double TAX_ARB = 15;
	// counter for all the arbeiter
	protected static int counter = 0;
	

	
	
	public Arbeiter() {
		
	}
	
	public Arbeiter(int id, String name, int stundenlohn, int anz_stunden, int schicht_Zulage) {
		super(id, name);
		this.stundenlohn = stundenlohn;
		this.anz_stunden = anz_stunden;
		this.schicht_Zulage = schicht_Zulage;
		
		counter++;

		
		
	}
	
//	@Override
//	public int compareTo(Mitarbeiter o) {
//		// TODO Auto-generated method stub
//		return super.compareTo(o);
//	}
	
	@Override
	public String toString() {
		
		return super.toString()+ 
				", Stundenlohn: " + getStundenlohn() + 
				", Stundenanzahl: " + getAnz_stunden() + 
				", Schicht Zulage: " + getSchicht_Zulage() +
				", Bruttogehalt: " + String.format("%1.2f €",berechneBrutto()) +
				", Netto: " + String.format("%1.2f €",berechneNetto());
	}
	
	public double getStundenlohn() {
		return stundenlohn;
	}

	public void setStundenlohn(int stundenlohn) {
		this.stundenlohn = stundenlohn;
	}

	public double getAnz_stunden() {
		return anz_stunden;
	}

	public void setAnz_stunden(int anz_stunden) {
		this.anz_stunden = anz_stunden;
	}

	public double getSchicht_Zulage() {
		return schicht_Zulage;
	}

	public void setSchicht_Zulage(int schicht_Zulage) {
		this.schicht_Zulage = schicht_Zulage;
	}
	
	//calculation of the brutto salary
	@Override
	public double berechneBrutto() {
		
		double brutto = this.stundenlohn * this.anz_stunden + this.schicht_Zulage;
		setBrutto(brutto);
		return getBrutto();
	}

	//calculation of the netto salary
	@Override
	public double berechneNetto() {
	
		return (berechneBrutto()* ((100-TAX_ARB)/100));
	}

	
	
}
