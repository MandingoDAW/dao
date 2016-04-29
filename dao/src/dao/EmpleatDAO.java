package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Aquesta interfÃ­cie especifica els mÃ¨todes que ha d'implementar les classes
 * del patrÃ³ DAO per accedir a l'entitat Empleat
 *
 * @author Sergi Grau
 * @version 1.0 28.02.2013
 */
public interface EmpleatDAO {

    /**
     * MÃ¨tode que afegeix un empleat a la base de dades
     *
     * @param empleat empleat (bean) que es vol afegir a la taula
     * @throws rellancem una excepciÃ³ per a que la gestioni qui invoca la
     * creaciÃ³ del empleat.
     */
    public void crearEmpleat(Empleat empleat) throws SQLException;

    public List<Empleat> llistarEmpleats() throws SQLException;

    /**
     * MÃ¨tode que esborra un empleat de la taula de la BD
     *
     * @param codi del empleat
     */
    public void esborrarEmpleat(int codi) throws SQLException;

    /**
     * MÃ¨tode que permet obtenir les dades d'un empleat
     *
     * @param codi se li passa com a parÃ metre el codi del empleat
     * @return el empleat
     */
    public Empleat llegirEmpleat(int codi) throws SQLException;

    /**
     * MÃ¨tode que permete actualitzar un empleat (que es passa com a parÃ metre)
     */
    public void actualitzarEmpleat(Empleat empleat) throws SQLException;

    /**
     * MÃ¨tode que retorna el nombre total de empleats de la BD
     *
     * @return enter amb el nombre total de empleats de la BD.
     */
    public int getTotalEmpleats() throws SQLException;

   
}
