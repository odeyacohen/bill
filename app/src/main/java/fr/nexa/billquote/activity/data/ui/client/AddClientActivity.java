package fr.nexa.billquote.activity.data.ui.client;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Client;
import fr.nexa.billquote.activity.data.remote.ClientService;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddClientActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPhone;
    private Button buttonAddClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        editTextName = findViewById(R.id.editTextClientName);
        editTextEmail = findViewById(R.id.editTextClientEmail);
        editTextPhone = findViewById(R.id.editTextClientPhone);
        buttonAddClient = findViewById(R.id.buttonAddClient);

        buttonAddClient.setOnClickListener(view -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String phone = editTextPhone.getText().toString();

            Client client = new Client ();

            ClientService service = ApiClient.getClient().create(ClientService.class);
            service.addClient(client).enqueue(new Callback<Client>() {
                @Override
                public void onResponse(Call<Client> call, Response<Client> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(AddClientActivity.this, "Client ajouté", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(AddClientActivity.this, "Erreur lors de l'ajout", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Client> call, Throwable t) {
                    Toast.makeText(AddClientActivity.this, "Erreur réseau", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
