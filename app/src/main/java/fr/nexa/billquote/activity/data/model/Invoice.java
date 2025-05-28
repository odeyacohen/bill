package fr.nexa.billquote.activity.data.model;

import java.util.Date;

public class Invoice {

    private int idFacture;
    private int numeroFacture;
    private Date dateFacture;
    private String statuFacture;
    private double montantFacture;
    private int idClient;
    private int idCommande;
    private int idSoc;

    public Invoice() {}

    public Invoice(int idFacture, int numeroFacture, Date dateFacture, String statuFacture,
                   double montantFacture, int idClient, int idCommande, int idSoc) {
        this.idFacture = idFacture;
        this.numeroFacture = numeroFacture;
        this.dateFacture = dateFacture;
        this.statuFacture = statuFacture;
        this.montantFacture = montantFacture;
        this.idClient = idClient;
        this.idCommande = idCommande;
        this.idSoc = idSoc;
    }

    // Getters and Setters

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public String getStatuFacture() {
        return statuFacture;
    }

    public void setStatuFacture(String statuFacture) {
        this.statuFacture = statuFacture;
    }

    public double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(double montantFacture) {
        this.montantFacture = montantFacture;
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
