package at.bfi.oop.aufgabe.firmaprojekt.controller;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import at.bfi.oop.aufgabe.firmaprojekt.model.Angestellter;
import at.bfi.oop.aufgabe.firmaprojekt.service.AngestellteService;
import at.bfi.oop.aufgabe.firmaprojekt.service.AngestellteServiceImpl;
import at.bfi.oop.aufgabe.firmaprojekt.view.FirmaView;
import at.bfi.oop.aufgabe.firmaprojekt.view.MyTable;

public class QueryMySqlDatabase {

	public static void main(String[] args) {
		
		try {
			usecase_1_angestellter_ausgeben();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static void usecase_1_angestellter_ausgeben() throws Exception {
		
		Connection con = null;
		Statement stmt;
		ResultSet rs;

		List<Angestellter> angestelltenListe = null;

		angestelltenListe = getAngestelle();
		

		String[] columnNames = {"id","name","grundgehalt","zulage"};
		String[][] rowData = new String[angestelltenListe.size()][columnNames.length];

		for (int i = 0; i < rowData.length; i++) {
			rowData[i][0] = Integer.toString(angestelltenListe.get(i).getId());
			rowData[i][1] = angestelltenListe.get(i).getName();
			rowData[i][2] = Double.toString(angestelltenListe.get(i).getGrundgehalt());
			rowData[i][3] = Double.toString(angestelltenListe.get(i).getZulage());
		}
		
		FirmaView firmaView = new FirmaView();
		
		

		firmaView.setVisible(true);
		
		firmaView.getB_showAngestellte().addActionListener(l -> {
			
			if(firmaView.getTable() == null) {
			
				MyTable table = new MyTable(rowData, columnNames);
				
				firmaView.setTable(table);
				
				firmaView.add(table, BorderLayout.SOUTH);
	
				firmaView.setVisible(true);
			}

		});

		firmaView.getB_hideAngestellte().addActionListener(l -> {

			if(firmaView.getTable() != null) {
				
				firmaView.remove(firmaView.getTable());
				firmaView.setTable(null);
				firmaView.setVisible(true);
				
			}
			
		});

	}

	
	



	//getAngestellte() -Abfrage über Service Layer
	public static List<Angestellter> getAngestelle() throws Exception {

		AngestellteService service = new AngestellteServiceImpl();

		return service.getAngestellte();

	}

}