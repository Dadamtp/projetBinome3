package controleur;

import ProduitDAO.I_ProduitDAO;
import ProduitDAO.ProduitDAOFactory;
import metier.Catalogue;

public class ctrlStock {
	private I_ProduitDAO dao;

	public ctrlStock(I_ProduitDAO _dao) {
		dao = _dao;
	}
	
	public String getStock(String nomCatalogue) {
		//return dao.toString(nomCatalogue);
		return null;
	}

	public void recupStock() {
		//cat.addProduits(dao.readAll());
	}
}
