package fr.nexa.billquote.activity.data.model;

public class User {

    private int idUtilisateur;
    private String mailUtilisateur;
    private String prenomUtilisateur;
    private String nomUtilisateur;
    private String telUtilisateur;
    private int idSoc;

    public User() {}

    public User(int idUtilisateur, String mailUtilisateur, String prenomUtilisateur,
                String nomUtilisateur, String telUtilisateur, int idSoc) {
        this.idUtilisateur = idUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.telUtilisateur = telUtilisateur;
        this.idSoc = idSoc;
    }

    // Getters and Setters

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getTelUtilisateur() {
        return telUtilisateur;
    }

    public void setTelUtilisateur(String telUtilisateur) {
        this.telUtilisateur = telUtilisateur;
    }

    public int getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(int idSoc) {
        this.idSoc = idSoc;
    }
}
