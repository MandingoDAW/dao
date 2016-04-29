package dao;

/**
 * Classe factoria d'objectes DAO.
 * Podem invocar a travÃ±es d'un mÃ¨tode estÃ tic la instanciaciÃ³
 * d'un objecte que correspon a un objecte EmpleatDAO.
 * Aquest patrÃ³ ens proporciona un contracte per crear objectes sense
 * especificar la  classe concreta a la que corresponen.
 * 
 * @author Sergi Grau.
 * @version 1.0 28.02.2013
 */

public class DAOFactory {

	public static EmpleatDAO crearEmpleatDAOJDBC(){
		return new EmpleatDAOImpl();
	}
        public static EmpleatDAO crearEmpleatDAOFitxers(){
		//return new EmpleatDAOImplFitxers();
                return null;
	}

}
