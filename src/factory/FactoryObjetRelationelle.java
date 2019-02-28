package factory;

import CatalogueDAO.CatalogueDAO_XML;
import CatalogueDAO.I_CatalogueDAO;
import ProduitDAO.AdaptateurProduitDAO_XML;
import ProduitDAO.I_ProduitDAO;


public class FactoryObjetRelationelle extends FactoryCatalogueProduit {

	@Override
	public I_ProduitDAO createProduitDAO() {
		return new AdaptateurProduitDAO_XML();
	}

	@Override
	public I_CatalogueDAO createCatalogueDAO() {
		return new CatalogueDAO_XML();
	}
	
}
