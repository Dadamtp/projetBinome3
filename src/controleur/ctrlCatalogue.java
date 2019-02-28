package controleur;

import java.util.ArrayList;
import java.util.List;

import CatalogueDAO.I_CatalogueDAO;
import metier.Catalogue;
import metier.I_Catalogue;

public class ctrlCatalogue {
	private List<I_Catalogue>	cats = new ArrayList<I_Catalogue>();
	private I_Catalogue current;
	private I_CatalogueDAO dao;
	private int nbCatalogues;
	
	public ctrlCatalogue(I_CatalogueDAO _dao) {
		dao = _dao;
		getCatalogues();
	}
	
	private void getCatalogues() {
		cats = dao.readAll();
		nbCatalogues = cats.size();
	}
	
	public String[] recupDetailsCatalogues() {
		return CataloguesListToString(dao.readAll());
	}
	
	private String[] CataloguesListToString(List<I_Catalogue> l) {
		String[] Catalogues = new String[l.size()];
		int i = 0;
		for (I_Catalogue cat : l) {
			Catalogues[i] = cat.getNomAndNbProduit();
			i++;
		}
		return Catalogues;
	}
	
	public int nbCatalogues() {
		return cats.size();
	}

	public String[] recupCatalogues() {
		return recupCatalogues(dao.readAll());
	}
	
	private String[] recupCatalogues(List<I_Catalogue> l) {
		String[] Catalogues = new String[l.size()];
		int i = 0;
		for (I_Catalogue cat : l) {
			Catalogues[i] = cat.getNom();
			i++;
		}
		return Catalogues;
	}

	public void addCatalogue(String nom) {
		dao.create(new Catalogue(nom));
	}
	
}
