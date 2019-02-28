package ProduitDAO;

import java.util.List;

import metier.I_Produit;

public class AdaptateurProduitDAO_XML implements I_ProduitDAO {

	private ProduitDAO_XML xmlDao;
	
	public  AdaptateurProduitDAO_XML() {
		xmlDao = new ProduitDAO_XML();
	}
	
	@Override
	public boolean create(I_Produit produit) {
		return xmlDao.creer(produit);
	}

	@Override
	public boolean update(I_Produit produit) {
		return xmlDao.creer(produit);
	}

	@Override
	public boolean delete(I_Produit produit) {
		return xmlDao.supprimer(produit);
	}

	@Override
	public I_Produit read(String nom) {
		return xmlDao.lire(nom);
	}

	@Override
	public List<I_Produit> readAll() {
		return xmlDao.lireTous();
	}

	@Override
	public void disconnect() {
		
	}
	
}
