package Exercici1;

import java.sql.*;
import java.io.*;
import java.util.*;


/**
 * Classe que estableix una connexiÃ³ amb una BD mitjanÃ§ant JDBC definit en un
 * fitxer. Utilitza blocs try/catch compatibles amb JDK 6 o <
 */
class ConnexioMesProves {

    public static void main(String args[]) {
        try {
            executarTest();
        } catch (SQLException ex) {
            for (Throwable t : ex)
                t.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Realitza un test amb la BD, creant una taula, afegint valors i recuperant
     * registres. Finalment esborra la taula creada
     */
    public static void executarTest() throws SQLException, IOException {
        Connection conn = obtenirConnexio();

        try {
            Statement stat = conn.createStatement();

            //stat.executeUpdate("CREATE TABLE prova (text CHAR(20))");
            stat.executeUpdate("CREATE TABLE alumne (codi int(10), nom varchar(20), nota int(10))");
            stat.executeUpdate("INSERT INTO prova VALUES ('hector')");

            ResultSet resultat = stat.executeQuery("SELECT * FROM prova");
            if (resultat.next()) {
                System.out.println(resultat.getString(1));
            }
            resultat.close();
            //stat.executeUpdate("DROP TABLE prova");
        } finally {
            conn.close();
        }
    }

    /**
     * Relitza una connexiÃ³ a la BD, a partir de les propietats especificades en
     * un fitxer database.properties
     *
     * @return la connexiÃ³ amb la BD
     */
    public static Connection obtenirConnexio() throws SQLException, IOException {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("C:\\Users\\Erik\\Documents\\NetBeansProjects\\JavaEE-Servlet-JSP-Javabean\\JDBC\\src\\Exercici1\\database.properties");
        props.load(in);
        in.close();

        String drivers = props.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
        String url = props.getProperty("jdbc.url");
        String usuari = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, usuari, password);
    }
}