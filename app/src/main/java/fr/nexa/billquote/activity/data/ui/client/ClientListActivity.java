package fr.nexa.billquote.activity.data.ui.client;// Importe
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.adapter.ClientAdapter;
import fr.nexa.billquote.activity.data.model.Client;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import fr.nexa.billquote.activity.data.remote.ClientService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ClientAdapter adapter;
    private ClientService clientService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_list);

        recyclerView = findViewById(R.id.recyclerViewClients);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        clientService = ApiClient.getClient().create(ClientService.class);

        loadClients();
    }

    private void loadClients() {
        clientService.getClients().enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new ClientAdapter(response.body());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(ClientListActivity.this, "Erreur de chargement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Toast.makeText(ClientListActivity.this, "Échec : " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ClientList", "onFailure: ", t);
            }
        });
    }
}
