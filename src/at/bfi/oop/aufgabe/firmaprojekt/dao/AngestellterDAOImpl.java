package at.bfi.oop.aufgabe.firmaprojekt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.bfi.oop.aufgabe.firmaprojekt.model.Angestellter;

public class AngestellterDAOImpl implements AngestellterDAO {

	@Override
	public List<Angestellter> getAngestellte() throws Exception {

		
		Connection con = DataAccess.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(
			"select id, name, grundgehalt, zulage " +
			"from Angestellte");
		
		List<Angestellter> list = new ArrayList<Angestellter>();
		while(rs.next()) {
			Angestellter angestellte = new Angestellter();
			angestellte.setId(rs.getInt("id"));
			angestellte.setName(rs.getString("name"));
			angestellte.setGrundgehalt(rs.getDouble("grundgehalt"));
			angestellte.setZulage(rs.getDouble("zulage"));
			list.add(angestellte);
		}
		
		return list;
	}
	}

	
	
