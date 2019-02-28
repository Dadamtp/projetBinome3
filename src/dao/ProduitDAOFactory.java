package dao;

public class ProduitDAOFactory {
	
	private static ProduitDAOFactory instance;
	
	protected ProduitDAOFactory() { }
	
	public I_ProduitDAO createProduitDAOInterface() {
		return new ProduitDAO();
		//return new AdaptateurProduitDAO_XML();
	}
	
	public static ProduitDAOFactory getInstance() {
		if (instance == null) 
			instance = new ProduitDAOFactory();
		return instance;
	}
}
