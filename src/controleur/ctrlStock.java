package controleur;

import dao.I_ProduitDAO;
import dao.ProduitDAOFactory;
import metier.Catalogue;

public class ctrlStock {
	private Catalogue cat = Catalogue.getInstance();
	private I_ProduitDAO dao;

	public ctrlStock() {
		dao = ProduitDAOFactory.getInstance().createProduitDAOInterface();
	}
	
	public String getStock() {
		return cat.toString();
	}

	public void recupStock() {
		cat.addProduits(dao.readAll());
	}
	
	public void disconnect() {
		dao.disconnect();
	}
}
