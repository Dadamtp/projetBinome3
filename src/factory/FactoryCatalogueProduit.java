package factory;

public abstract class FactoryCatalogueProduit {
	private static FactoryCatalogueProduit instance;
	
	public FactoryCatalogueProduit() { }
	
	public FactoryCatalogueProduit getInstance() {
		if (instance == null) {
			instance = new ;
		}
		return instance;
	}
	
	public FactoryCatalogueProduit createProduitDAO() {
		return new ProduitDAO();
	}
	
	public FactoryCatalogueProduit createCatalogueDAO() {
		return new CatalogueDAO();
	}
}
