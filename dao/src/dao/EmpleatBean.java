package dao;

import java.util.Date;

/**
 *
 * @author sergi
 */
public class EmpleatBean implements Empleat{

    private int codi;
    private String nom;
    private Date dataContracte;

    public EmpleatBean() {
    }

    public EmpleatBean(int codi, String nom, Date dataContracte) {
        this.codi = codi;
        this.nom = nom;
        this.dataContracte = dataContracte;
    }

 
    @Override
    public int getCodi() {
       return codi;
    }

    @Override
    public void setCodi() {
        this.codi=codi;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom=nom;
    }

    @Override
    public Date getDataContracte() {
        return dataContracte;
    }

    @Override
    public void setDateContracte(Date data) {
        this.dataContracte=data;
    }

    @Override
    public String toString() {
        return "EmpleatBean{" + "codi=" + codi + ", nom=" + nom + ", dataContracte=" + dataContracte + '}';
    }
    
}
