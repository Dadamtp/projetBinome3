package metier;

import java.text.NumberFormat;
import java.util.Locale;

public class Produit implements I_Produit {

	private int _quantiteStock;
	private String _nom;
	private double _prixUnitaireHT;
	private static double _tauxTVA = 0.2;
	
	public Produit (final String nom, final double prixUnitaireHT, final int quantite){
		this._quantiteStock = quantite;
		this._prixUnitaireHT = prixUnitaireHT;
		this._nom = nom.replaceAll("\t", " ");	
		this._nom = this._nom.trim();
		this._nom.replace(this._nom.substring(
				this._nom.lastIndexOf(this._nom), this._nom.lastIndexOf(this._nom)), "");
	}
	
	
	@Override
	public boolean ajouter(int qteAchetee) {
		this._quantiteStock += qteAchetee;
		return true;
	}

	@Override
	public boolean enlever(int qteVendue) {
		if (this._quantiteStock - qteVendue >= 0){
			this._quantiteStock -= qteVendue;
			return true;
		}
		else return false;
	}

	@Override
	public String getNom() {
		return this._nom;
	}

	@Override
	public int getQuantite() {
		return this._quantiteStock;
	}
	
	public void setQuantite(int qte) {
		this._quantiteStock = qte;
	}

	@Override
	public double getPrixUnitaireHT() {
		return this._prixUnitaireHT;
	}

	@Override
	public double getPrixUnitaireTTC() {
		return this._prixUnitaireHT * (1.0 + Produit._tauxTVA);
	}

	@Override
	public double getPrixStockTTC() {
		return this.getPrixUnitaireTTC() * this._quantiteStock;
	}
	
	@Override
	public String toString() {
		//TODO FAIRE UNE METHODE MONNAIE TO STRING 
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String prixUnitaireHT  = format.format(this.getPrixUnitaireHT());
		String prixUnitaireTTC = format.format(this.getPrixUnitaireTTC());
		return this.getNom() + " - prix HT : " + prixUnitaireHT + " - prix TTC : " + prixUnitaireTTC + " - quantité en stock : " + this.getQuantite();
	}
}
