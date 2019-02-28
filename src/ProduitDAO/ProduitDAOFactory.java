package ProduitDAO;

public class ProduitDAOFactory {
	
	protected ProduitDAOFactory() { }
	
	public I_ProduitDAO createProduitDAOInterface() {
		return new ProduitDAO();
		//return new AdaptateurProduitDAO_XML();
	}
	
}
