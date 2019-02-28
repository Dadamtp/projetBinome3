package controleur;

import graphique.FenetreAffichage;
import metier.Catalogue;
import metier.Produit;
import dao.*;

public class ctrlProduit {
	private Catalogue cat = Catalogue.getInstance();
	private I_ProduitDAO dao;
	
	public ctrlProduit() {
		dao = ProduitDAOFactory.getInstance().createProduitDAOInterface();
	}
	
	public  boolean addProduit(String nom, double prix, int qte) {
		Produit p;
		boolean ret = false;
		if (cat.addProduit(nom, prix, qte))
		{
			p = new Produit(nom, prix, qte);
			dao.create(p);
			ret = true;
		}
		else
		{
			new FenetreAffichage("Création Impossible.");
		}
		return ret;
	}
	
	public  boolean removeProduit(String nom) {
		boolean ret = false;
		if (cat.removeProduit(nom))
		{
			dao.delete(cat.getProduitByName(nom));
			ret = true;
		}
		return ret;
	}

	public  String[] getStockInTab() {
		return cat.getNomProduits();
	}
}
