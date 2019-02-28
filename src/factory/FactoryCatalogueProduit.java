package factory;

import CatalogueDAO.I_CatalogueDAO;
import ProduitDAO.I_ProduitDAO;

public abstract class FactoryCatalogueProduit {
	private static FactoryCatalogueProduit instance;
	
	public FactoryCatalogueProduit() { }
	
	public static FactoryCatalogueProduit getInstance() {
		if (instance == null) {
			instance = new FactoryRelationelle();
		}
		return instance;
	}
	
	public abstract I_ProduitDAO createProduitDAO();
	public abstract I_CatalogueDAO createCatalogueDAO();
}
