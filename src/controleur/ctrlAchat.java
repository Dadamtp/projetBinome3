package controleur;

import graphique.FenetreAffichage;
import dao.I_ProduitDAO;
import dao.ProduitDAOFactory;
import metier.Catalogue;

public class ctrlAchat {
	private Catalogue cat = Catalogue.getInstance();
	private I_ProduitDAO dao;
	
	public ctrlAchat() {
		dao = ProduitDAOFactory.getInstance().createProduitDAOInterface();
	}
	
	public  boolean acheterStock(String nomProduit, int qteAchetee) {
		if (cat.acheterStock(nomProduit, qteAchetee)) {
			dao.update(cat.getProduitByName(nomProduit));
			return true;
		}
		return false;
	}
	
	public  boolean vendreStock(String nomProduit, int qteVendue) {
		if (cat.vendreStock(nomProduit, qteVendue))
		{
			dao.update(cat.getProduitByName(nomProduit));
			return true;
		}
		else
		{
			new FenetreAffichage("Vente impossible, quantitée insuffisante");
			return false;
		}
	}
	public String[] getStockInTab() {
		return cat.getNomProduits();
	}
	
	public void disconnect() {
		dao.disconnect();
	}
}
