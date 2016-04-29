package dao;

import java.io.IOException;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que permet implementar el patrÃ³ DAO. Implementa la interfÃ­cie
 * EmpleatDAO que permet accedir a una entitat Empleat a la BD. Aquesta classe
 * correspon al model del negoci.
 *
 * @author Sergi Grau
 * @version 1.0 28.2.2013
 */
public class EmpleatDAOImpl implements EmpleatDAO {

    private BDAccessor bd = new BDAccessor();

    @Override
    public void crearEmpleat(Empleat empleat) throws SQLException {
        
        PreparedStatement pstmt = null;
        try (Connection connexio = bd.obtenirConnexio()) {
       
            
        
            pstmt = connexio.prepareStatement(
                    "INSERT INTO EMPLEAT_DAO (codi, nom, data) VALUES (?,?,?)");
            pstmt.setInt(1, empleat.getCodi());
            pstmt.setString(2, empleat.getNom());
            pstmt.setDate(3, new java.sql.Date (empleat.getDataContracte().getTime()) );
            pstmt.executeUpdate();
            connexio.commit();

        } catch (Exception e) {
e.printStackTrace();
        }
    }

    @Override
    public List<Empleat> llistarEmpleats() throws SQLException {
        PreparedStatement pstmt = null;
        List<Empleat> llista = new ArrayList<>(50);
        try (Connection connexio = bd.obtenirConnexio()) {
            String cadenaSQL = "SELECT * FROM EMPLEAT_DAO";
            pstmt = connexio.prepareStatement(cadenaSQL);
            try (ResultSet resultat = pstmt.executeQuery()) {
                while (resultat.next()) {
                    
                    llista.add(new EmpleatBean(resultat.getInt(1),
                           resultat.getString(2),
                            resultat.getDate(3)));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return llista;
    }

    @Override
    public void esborrarEmpleat(int codi) throws SQLException {


        PreparedStatement pstmt = null;
        try (Connection connexio = bd.obtenirConnexio()) {

            pstmt = connexio.prepareStatement(
                    "DELETE FROM EMPLEAT_DAO WHERE codi= ?");
            pstmt.setInt(1, codi);
            pstmt.executeUpdate();
            connexio.commit();
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public Empleat llegirEmpleat(int codi) throws SQLException {
        PreparedStatement pstmt = null;
        Empleat empleat=null;
        try (Connection connexio = bd.obtenirConnexio()) {
            String cadenaSQL = "SELECT * FROM EMPLEAT_DAO WHERE codi = ?";
            pstmt = connexio.prepareStatement(cadenaSQL);
            pstmt.setInt(1, codi);
            try (ResultSet resultat = pstmt.executeQuery()) {
                if (resultat.next()) {
                    
                   empleat = new EmpleatBean(resultat.getInt(1),
                           resultat.getString(2),
                            resultat.getDate(3));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empleat;
    }

    @Override
    public void actualitzarEmpleat(Empleat empleat) {
    }

    @Override
    public int getTotalEmpleats() throws SQLException {
        PreparedStatement pstmt = null;
        
        try (Connection connexio = bd.obtenirConnexio()) {
            String cadenaSQL = "SELECT count(codi) as total FROM EMPLEAT_DAO";
            pstmt = connexio.prepareStatement(cadenaSQL);
            try (ResultSet resultat = pstmt.executeQuery()) {
                if (resultat.next()) {
                  return resultat.getInt(1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           return 0;
       
    }
}
