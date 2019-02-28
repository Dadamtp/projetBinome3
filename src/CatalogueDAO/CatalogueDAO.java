package CatalogueDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Catalogue;
import metier.I_Catalogue;
import utils.Connexion;

public class CatalogueDAO implements I_CatalogueDAO {
	private Connection cn;
	private CallableStatement cs;
	private Statement st;
	private ResultSet rs;
	
	public CatalogueDAO() {
		cn = Connexion.getInstance().getConnection();
	}
	
	@Override
	public boolean create(I_Catalogue catalogue) {
		boolean ret = false;
		try {
			cs = cn.prepareCall("{call ajoutCatalogue(?)}");
			cs.setString(1, catalogue.getNom());
			cs.execute();
			ret = true;
		} catch (SQLException e) {
			System.out.println("Problème à la création d'un catalogue.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean update(I_Catalogue catalogue) {
		return false;
	}

	@Override
	public boolean delete(I_Catalogue catalogue) {
		
		return false;
	}

	@Override
	public I_Catalogue read(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<I_Catalogue> readAll() {
		List<I_Catalogue> l = new ArrayList<I_Catalogue>();
		String nom;

		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT nomCatalogue FROM catalogues");
			while (rs.next()) {
				nom = rs.getString(1);
				I_Catalogue c = new Catalogue(nom);
				l.add(c);
			}
		} catch (SQLException e) {
			System.out.println("Impossible de recupérer le nom des catalogues.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return l;
	}
}
