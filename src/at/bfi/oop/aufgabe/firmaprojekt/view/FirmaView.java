package at.bfi.oop.aufgabe.firmaprojekt.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class FirmaView extends JFrame {

	private JPanel p_Angestellte;
	private JButton b_showAngestellte;
	private JButton b_hideAngestellte;
	private MyTable table;
	private String columnNames[];
	private String rowData[][];

	public FirmaView()  {
		initApp();
	}


	private void initApp() {
	
		setPreferredSize(new Dimension(410, 350));
		setLocation(200, 200);
	
		setForeground(Color.black);
		setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		setTitle("Angestellten Abfrage");
		getContentPane().setBackground(Color.white);
		setLayout(new BorderLayout(25, 25));
		
		initialLoginPanelWithElements();
		
		setVisible(true);

	}

	private void initialLoginPanelWithElements() {
		
		p_Angestellte = new JPanel();
	
		b_showAngestellte = new JButton("Show Angestellte");
		b_hideAngestellte = new JButton("Hide Angestellte");
		
		p_Angestellte.setLayout(new GridLayout(2,2,7,7));
		
		p_Angestellte.add(b_showAngestellte);
		p_Angestellte.add(b_hideAngestellte);
		p_Angestellte.add(new JLabel());
		p_Angestellte.add(new JLabel());
	
		p_Angestellte.setBackground(Color.white);
		add(p_Angestellte, BorderLayout.CENTER);
		
		pack();
	}

	

	public JPanel getP_Angestellte() {
		return p_Angestellte;
	}


	public void setP_Angestellte(JPanel p_Angestellte) {
		this.p_Angestellte = p_Angestellte;
	}

	public JButton getB_showAngestellte() {
		return b_showAngestellte;
	}


	public void setB_showAngestellte(JButton b_showAngestellte) {
		this.b_showAngestellte = b_showAngestellte;
	}


	public JButton getB_hideAngestellte() {
		return b_hideAngestellte;
	}


	public void setB_hideAngestellte(JButton b_hideAngestellte) {
		this.b_hideAngestellte = b_hideAngestellte;
	}


	public MyTable getTable() {
		return table;
	}


	public void setTable(MyTable table) {
		this.table = table;
	}


	public String[] getColumnNames() {
		return columnNames;
	}


	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}


	public String[][] getRowData() {
		return rowData;
	}


	public void setRowData(String[][] rowData) {
		this.rowData = rowData;
	}
	
	
		
	
	}
