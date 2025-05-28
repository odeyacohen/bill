package fr.nexa.billquote.activity.data.model;

import java.util.Date;

public class Quote {

    private int idDevis;
    private int numeroDevis;
    private Date dateDevis;
    private String statuDevis;
    private double montantDevis;
    private int idFacture;
    private int idClient;
    private int idCommande;
    private int idSoc;

    public Quote() {}

    public Quote(int idDevis, int numeroDevis, Date dateDevis, String statuDevis,
                 double montantDevis, int idFacture, int idClient, int idCommande, int idSoc) {
        this.idDevis = idDevis;
        this.numeroDevis = numeroDevis;
        this.dateDevis = dateDevis;
        this.statuDevis = statuDevis;
        this.montantDevis = montantDevis;
        this.idFacture = idFacture;
        this.idClient = idClient;
        this.idCommande = idCommande;
        this.idSoc = idSoc;
    }

    // Getters and Setters

    public int getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    public int getNumeroDevis() {
        return numeroDevis;
    }

    public void setNumeroDevis(int numeroDevis) {
        this.numeroDevis = numeroDevis;
    }

    public Date getDateDevis() {
        return dateDevis;
    }

    public void setDateDevis(Date dateDevis) {
        this.dateDevis = dateDevis;
    }

    public String getStatuDevis() {
        return statuDevis;
    }

    public void setStatuDevis(String statuDevis) {
        this.statuDevis = statuDevis;
    }

    public double getMontantDevis() {
        return montantDevis;
    }

    public void setMontantDevis(double montantDevis) {
        this.montantDevis = montantDevis;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(int idSoc) {
        this.idSoc = idSoc;
    }
}
