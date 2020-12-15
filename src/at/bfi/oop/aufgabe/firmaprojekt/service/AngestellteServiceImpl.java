package at.bfi.oop.aufgabe.firmaprojekt.service;

import java.util.List;

import at.bfi.oop.aufgabe.firmaprojekt.dao.AngestellterDAO;
import at.bfi.oop.aufgabe.firmaprojekt.dao.AngestellterDAOImpl;
import at.bfi.oop.aufgabe.firmaprojekt.model.Angestellter;

public class AngestellteServiceImpl implements AngestellteService{

	@Override
	public List<Angestellter> getAngestellte() throws Exception {
		
		AngestellterDAO angestellteDao = new AngestellterDAOImpl();
		
		
		return angestellteDao.getAngestellte();
	}

}
