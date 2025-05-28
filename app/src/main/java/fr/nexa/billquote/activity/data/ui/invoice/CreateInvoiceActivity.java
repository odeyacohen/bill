package fr.nexa.billquote.activity.data.ui.invoice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Invoice;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import fr.nexa.billquote.activity.data.remote.InvoiceService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateInvoiceActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAmount, editTextClientId;
    private Button buttonCreateInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_invoice);

        editTextTitle = findViewById(R.id.editTextInvoiceTitle);
        editTextAmount = findViewById(R.id.editTextInvoiceAmount);
        editTextClientId = findViewById(R.id.editTextClientId);
        buttonCreateInvoice = findViewById(R.id.buttonCreateInvoice);

        buttonCreateInvoice.setOnClickListener(view -> {
            String title = editTextTitle.getText().toString();
            double amount = Double.parseDouble(editTextAmount.getText().toString());
            int clientId = Integer.parseInt(editTextClientId.getText().toString());

            Invoice invoice = new Invoice();

            InvoiceService service = ApiClient.getClient().create(InvoiceService.class);
            service.addInvoice(invoice).enqueue(new Callback<Invoice>() {
                @Override
                public void onResponse(Call<Invoice> call, Response<Invoice> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(CreateInvoiceActivity.this, "Facture créée", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(CreateInvoiceActivity.this, "Erreur de création", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Invoice> call, Throwable t) {
                    Toast.makeText(CreateInvoiceActivity.this, "Échec de connexion", Toast.LENGTH_SHORT).show();
                }
            });
        });

        Button buttonBack = findViewById(R.id.buttonBackToInvoices);
        buttonBack.setOnClickListener(v -> finish());

    }
}

