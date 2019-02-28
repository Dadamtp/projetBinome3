package controleur;

import graphique.FenetreAffichage;
import metier.Catalogue;
import metier.Produit;
import ProduitDAO.I_ProduitDAO;
import ProduitDAO.ProduitDAOFactory;
import factory.*;

public class ctrlProduit {
	private I_ProduitDAO dao;
	
	public ctrlProduit(I_ProduitDAO _dao) {
		dao = _dao;
	}
	
	public  boolean addProduit(String nom, double prix, int qte) {
		/*Produit p;
		boolean ret = false;
		if (cat.addProduit(nom, prix, qte))
		{
			p = new Produit(nom, prix, qte);
			dao.create(p);
			ret = true;
		}
		else
		{
			new FenetreAffichage("Cr�ation Impossible.");
		}
		return ret;*/
		return false;
	}
	
	public  boolean removeProduit(String nom) {
		/*boolean ret = false;
		if (cat.removeProduit(nom))
		{
			dao.delete(cat.getProduitByName(nom));
			ret = true;
		}
		return ret;*/
		return false;
	}

	public  String[] getStockInTab() {
		//return cat.getNomProduits();
		return null;
	}
}
