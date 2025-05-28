package fr.nexa.billquote.activity.data.model;

public class Client {

    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String nomSocClient;
    private String mailClient;
    private String telClient;
    private int idSoc;  // ID de la société associée

    public Client() {
        // Constructeur vide requis pour certaines opérations (ex: Firebase, SQLite cursor)
    }

    public Client(int idClient, String nomClient, String prenomClient, String nomSocClient,
                  String mailClient, String telClient, int idSoc) {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.nomSocClient = nomSocClient;
        this.mailClient = mailClient;
        this.telClient = telClient;
        this.idSoc = idSoc;
    }

    // Getters et Setters

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getNomSocClient() {
        return nomSocClient;
    }

    public void setNomSocClient(String nomSocClient) {
        this.nomSocClient = nomSocClient;
    }

    public String getMailClient() {
        return mailClient;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public int getIdSoc() {
        return idSoc;
    }

    public void setIdSoc(int idSoc) {
        this.idSoc = idSoc;
    }

    @Override
    public String toString() {
        return nomClient + " " + prenomClient + " (" + nomSocClient + ")";
    }


}
