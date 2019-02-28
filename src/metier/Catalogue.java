package metier;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Catalogue implements I_Catalogue {
	//SINGLETON
	private static Catalogue instance;	
	private ArrayList<I_Produit> _lesProduits = null;
	private String nom;
	
	public synchronized static Catalogue getInstance()
	{
		if (instance == null)
			instance = new Catalogue();
		return instance;
	}
	
	protected Catalogue() {
		this._lesProduits = new ArrayList<I_Produit>();
	}
	
	private boolean existInCatalogueByNom(ArrayList<I_Produit> l, String nom) {
		for (I_Produit produit : l) {
			if (produit.getNom().equals(nom))
				return true;
		}
		return false;
	}
	
	@Override
	public boolean addProduit(I_Produit produit) {
		if (produit == null)
			return false;
		if (!(existInCatalogueByNom(_lesProduits, produit.getNom()))
				&& produit.getPrixUnitaireHT() > 0
				&& produit.getQuantite() >= 0)
		{
			this._lesProduits.add(produit);
			
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addProduit(String nom, double prix, int qte) {
		I_Produit nouveauProduit = new Produit(nom, prix, qte);
		return this.addProduit(nouveauProduit);
	}

	@Override
	public int addProduits(List<I_Produit> l) {
		int compteur = 0;
		
		if (l == null)
			return 0;
		for (I_Produit produit : l) {
			if ((!(existInCatalogueByNom(_lesProduits, produit.getNom()))) 
					&& (produit.getPrixUnitaireHT() > 0) 
					&& (produit.getQuantite() >= 0)) 
			{
				this._lesProduits.add(produit);
				compteur++;
			}
		}
		return compteur;
	}

	@Override
	public boolean removeProduit(String nom) {
		for (I_Produit produit : _lesProduits) {
			if (produit.getNom() == nom) {
				this._lesProduits.remove(produit);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		for (I_Produit produit : _lesProduits) {
			if (nomProduit != null && qteAchetee > 0) {
				if (produit.getNom() == nomProduit) {
					produit.ajouter(qteAchetee);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean contains(I_Produit p) {
		return (this.toString().equals(p.toString()));
	}
	
	@Override
	public boolean vendreStock(String nomProduit, int qteVendue) {
		for (I_Produit produit : _lesProduits) {
			if (nomProduit != null && qteVendue > 0 )
			{
				if (produit.getNom() == nomProduit && 
						produit.getQuantite() >= 0 && qteVendue <= produit.getQuantite())
				{
					produit.enlever(qteVendue);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String[] getNomProduits() {
		String[] nomsProduits = new String[_lesProduits.size()];
		int i = 0;
		for (I_Produit produit : _lesProduits) {
			nomsProduits[i] = produit.getNom();
			i++;
		}
		Arrays.sort(nomsProduits);
		return nomsProduits;
	}

	@Override
	public double getMontantTotalTTC() {
		double montantTotalTTC = 0;
		for (I_Produit produit : _lesProduits) {
			montantTotalTTC += produit.getPrixStockTTC();
		}
		montantTotalTTC = (double)Math.round(montantTotalTTC * 100) / 100;
		return montantTotalTTC;
	}
	
	@Override
	public String toString() {
		String desc = "";
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.FRANCE);

		for (I_Produit produit : _lesProduits) {
			desc += produit.toString() + "\n";
		}
		return desc + "\nMontant total TTC du stock : " + format.format(this.getMontantTotalTTC());
	}
	@Override
	public void clear() {
		_lesProduits = null;
	}
	
	public I_Produit getProduitByName(String nom) {
		int i = 0;
		
		while (!nom.equals(_lesProduits.get(i).getNom())) {
			i++;
		}
		
		return _lesProduits.get(i);
	}

}
