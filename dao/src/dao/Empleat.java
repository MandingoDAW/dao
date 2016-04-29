package dao;

import java.util.Date;

/**
 * InterfÃ­cie que representa un Client.
 * @author Sergi Grau
 * @version 1.0 28.02.2013
 */

public interface Empleat
{
	
	public int getCodi();
        public void setCodi();
        public String getNom();
        public void setNom(String nom);
        public Date getDataContracte();
        public void setDateContracte(Date data);

}
