package factory;

import CatalogueDAO.CatalogueDAO;
import CatalogueDAO.I_CatalogueDAO;
import ProduitDAO.I_ProduitDAO;
import ProduitDAO.ProduitDAO;

public class FactoryRelationelle extends FactoryCatalogueProduit {

	@Override
	public I_ProduitDAO createProduitDAO() {
		return new ProduitDAO();
	}

	@Override
	public I_CatalogueDAO createCatalogueDAO() {
		return new CatalogueDAO();
	}
}
