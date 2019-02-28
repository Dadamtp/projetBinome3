package controleur;

import java.util.ArrayList;
import java.util.List;

import CatalogueDAO.I_CatalogueDAO;
import factory.FactoryCatalogueProduit;
import factory.FactoryRelationelle;
import metier.I_Catalogue;

public class ctrlPrincipal {
	
	private ctrlAchat controleurAchat;
	private ctrlProduit controleurProduit;
	private ctrlStock controleurStock;
	private ctrlCatalogue controleurCatalogue;
	
	private FactoryCatalogueProduit factory;
	
	public ctrlPrincipal() {
		factory = FactoryCatalogueProduit.getInstance();
		controleurCatalogue = new ctrlCatalogue(factory.createCatalogueDAO());
	}
	
	//controleurStock
	public String getStock() {
		return null;
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
		
	}

	public void addCatalogue(String nom) {
		controleurCatalogue.addCatalogue(nom);
	}
}
