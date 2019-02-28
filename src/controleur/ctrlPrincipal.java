package controleur;

import java.util.ArrayList;
import java.util.List;

import CatalogueDAO.I_CatalogueDAO;
import factory.FactoryCatalogueProduit;
import factory.FactoryRelationelle;
import metier.I_Catalogue;
import utils.Connexion;

public class ctrlPrincipal {
	
	private ctrlAchat controleurAchat;
	private ctrlProduit controleurProduit;
	private ctrlStock controleurStock;
	private ctrlCatalogue controleurCatalogue;
	private FactoryCatalogueProduit factory;	
	private String currentCatalogue;
	
	public ctrlPrincipal() {
		factory = FactoryCatalogueProduit.getInstance();
		controleurCatalogue = new ctrlCatalogue(factory.createCatalogueDAO());
		controleurStock = new ctrlStock(factory.createProduitDAO());
	}
	
	//controleurStock
	public String getStock() {
		return controleurStock.getStock(currentCatalogue);
	}
	
	public void recupStock() {
		
	}
	
	//controleurProduit
	public boolean addProduit(String nom, double prix, int qte) {
		return false;
	}
	
	public boolean removeProduit(String nom) {
		return false;
	}
	
	//controleurAchat
	public boolean acheterStock(String nomProduit, int qteAchetee) {
		return true;
	}
	
	public boolean vendreStock(String nomProduit, int qteVendue) {
		return true;
	}
	
	//controleurCatalogues
	public int nbCatalogues() {
		return controleurCatalogue.nbCatalogues();
	}
	
	public String[] recupDetailsCatalogues() {
		return controleurCatalogue.recupDetailsCatalogues();
	}
	
	public String[] recupCatalogues() {
		return controleurCatalogue.recupCatalogues();
	}
	
	public void disconnect() {
		Connexion.getInstance().Deconnexion();
	}

	public void addCatalogue(String nom) {
		controleurCatalogue.addCatalogue(nom);
	}

	public void selectionnerCatalogue(String nomCatalogue) {
		controleurCatalogue.selectionnerCatalogue(nomCatalogue);
		setCurrentCatalogue(nomCatalogue);
	}
	
	private void setCurrentCatalogue(String nom) {
		currentCatalogue = nom;
	}
}
