package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import metier.I_Produit;
import metier.Produit;

public class ProduitDAO implements I_ProduitDAO {
	private PreparedStatement ps;
	private CallableStatement cs;
	private Statement st;
	private ResultSet rs;
	private Connection cn;

	public ProduitDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//cn = DriverManager.getConnection("jdbc:oracle:thin:@gloin:1521:iut", "perezd", "123");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@162.38.222.149:1521:iut", "perezd", "123");
			
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean create(I_Produit produit) {
		String nom = produit.getNom();
		int quantite = produit.getQuantite();
		double prix = produit.getPrixUnitaireHT();
		
		try {
			cs = cn.prepareCall("{call ajoutProduits(?, ?, ?)}");		
			cs.setString(1, nom);
			cs.setInt(2, quantite);
			cs.setDouble(3, prix);
			cs.execute();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(I_Produit produit) {
		try {
			
			ps = cn.prepareStatement("UPDATE Produits SET quantite=? where nomProduit=?");
			ps.setInt(1, produit.getQuantite());
			ps.setString(2, produit.getNom());
			System.out.println("avant execute");
			ps.executeUpdate();
			System.out.println("UPDATE Produits SET quantite = " + produit.getQuantite() + " WHERE nomProduit = " + produit.getNom());
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean delete(I_Produit produit) {
		int ret;
		try {
			ps = cn.prepareStatement("DELETE FROM produits where nomProduit = ?");
			ps.setString(1, produit.getNom());
			ret = ps.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public I_Produit read(String nom) {
		I_Produit p;
		int quantite;
		double prix;
		try {
			ps = cn.prepareStatement("SELECT nomProduit, quantite, prix FROM produits WHERE nomProduit = '?'");
			ps.setString(1, nom);
			rs = ps.executeQuery();

			if (rs.next())
			{
				quantite = rs.getInt(2);
				prix  = rs.getDouble(3);
				p = new Produit(nom, prix, quantite);
				return p;
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<I_Produit> readAll() {
		List<I_Produit> l = new ArrayList<I_Produit>();
		String	nom;
		int		quantite;
		double	prix;
		
		try {
			st = cn.createStatement();
			rs = st.executeQuery("SELECT nomProduit, quantite, prix FROM produits");
			while (rs.next())
			{
				nom = rs.getString(1);
				quantite = rs.getInt(2);
				prix = rs.getDouble(3);
				System.out.println(nom + " " + quantite + " " + prix);
				I_Produit p = new Produit(nom, prix, quantite);
				l.add(p);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return l;
	}
	
	public void disconnect() {
		try {
			if (cn != null)
				cn.close();
			System.out.println("Déconnexion");
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
}
