package CatalogueDAO;

public class CatalogueDAOFactory {
	
	public CatalogueDAOFactory () { }
	
	public I_CatalogueDAO createCatalogueDAOInterface() {
		return new CatalogueDAO();
		//return new CatalogueDAO_XML();
	}
}
