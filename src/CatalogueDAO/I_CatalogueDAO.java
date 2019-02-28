package CatalogueDAO;

import java.util.List;
import metier.I_Catalogue;

public interface I_CatalogueDAO {
	public boolean create(I_Catalogue catalogue);
	public boolean update(I_Catalogue catalogue);
	public boolean delete(I_Catalogue catalogue);
	public I_Catalogue read(String nom);
	public List<I_Catalogue> readAll();
}
