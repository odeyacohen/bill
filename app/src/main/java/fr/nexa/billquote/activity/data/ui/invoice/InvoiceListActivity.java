package fr.nexa.billquote.activity.data.ui.invoice;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.adapter.InvoiceAdapter;
import fr.nexa.billquote.activity.data.model.Invoice;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import fr.nexa.billquote.activity.data.remote.InvoiceService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvoiceListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private InvoiceAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice_list);

        recyclerView = findViewById(R.id.recyclerViewInvoices);
        progressBar = findViewById(R.id.progressBarInvoices);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InvoiceAdapter();
        recyclerView.setAdapter(adapter);

        Button buttonCreate = findViewById(R.id.buttonCreateInvoice);
        buttonCreate.setOnClickListener(view -> {
            Intent intent = new Intent(InvoiceListActivity.this, CreateInvoiceActivity.class);
            startActivity(intent);
        });


        loadInvoices();
    }

    private void loadInvoices() {
        progressBar.setVisibility(View.VISIBLE);

        InvoiceService service = ApiClient.getClient().create(InvoiceService.class);
        service.getInvoices().enqueue(new Callback<List<Invoice>>() {
            @Override
            public void onResponse(Call<List<Invoice>> call, Response<List<Invoice>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setInvoices(response.body());
                } else {
                    Toast.makeText(InvoiceListActivity.this, "Erreur de chargement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Invoice>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(InvoiceListActivity.this, "Échec de connexion", Toast.LENGTH_SHORT).show();
            }
        });

            
        Button buttonBackToHome = findViewById(R.id.buttonBackToHome);
        buttonBackToHome.setOnClickListener(v -> finish());

    }
}

