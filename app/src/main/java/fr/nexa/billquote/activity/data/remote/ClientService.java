package fr.nexa.billquote.activity.data.remote;


import java.util.List;

import fr.nexa.billquote.activity.data.model.Client;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientService {
    @GET("clients") // Assure-toi que l’endpoint correspond à ton backend
    Call<List<Client>> getClients();

    Call<Client> addClient(Client client);
}

