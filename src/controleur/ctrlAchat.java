package controleur;

import ProduitDAO.I_ProduitDAO;
import ProduitDAO.ProduitDAOFactory;
import graphique.FenetreAffichage;
import metier.Catalogue;

public class ctrlAchat {
	private I_ProduitDAO dao;
	
	public ctrlAchat(I_ProduitDAO _dao) {
		dao = _dao;
	}
	
	public  boolean acheterStock(String nomProduit, int qteAchetee) {
		/*if (cat.acheterStock(nomProduit, qteAchetee)) {
			dao.update(cat.getProduitByName(nomProduit));
			return true;
		}*/
		return false;
	}
	
	public  boolean vendreStock(String nomProduit, int qteVendue) {
		/*if (cat.vendreStock(nomProduit, qteVendue))
		{
			dao.update(cat.getProduitByName(nomProduit));
			return true;
		}
		else
		{
			new FenetreAffichage("Vente impossible, quantitée insuffisante");
			return false;
		}*/
		return false;
	}
	
	public String[] getStockInTab() {
		//return cat.getNomProduits();
		return null;
	}
	
}
