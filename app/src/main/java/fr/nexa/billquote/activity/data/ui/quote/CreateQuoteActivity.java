package fr.nexa.billquote.activity.data.ui.quote;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.model.Quote;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import fr.nexa.billquote.activity.data.remote.QuoteService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateQuoteActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAmount, editTextClientId;
    private Button buttonCreateQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote);

        editTextTitle = findViewById(R.id.editTextQuoteTitle);
        editTextAmount = findViewById(R.id.editTextQuoteAmount);
        editTextClientId = findViewById(R.id.editTextClientId);
        buttonCreateQuote = findViewById(R.id.buttonCreateQuote);

        buttonCreateQuote.setOnClickListener(view -> {
            String title = editTextTitle.getText().toString();
            double amount = Double.parseDouble(editTextAmount.getText().toString());
            int clientId = Integer.parseInt(editTextClientId.getText().toString());

            Quote quote = new Quote();

            QuoteService service = ApiClient.getClient().create(QuoteService.class);
            service.addQuote(quote).enqueue(new Callback<Quote>() {
                @Override
                public void onResponse(Call<Quote> call, Response<Quote> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(CreateQuoteActivity.this, "Devis créé", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(CreateQuoteActivity.this, "Erreur de création", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Quote> call, Throwable t) {
                    Toast.makeText(CreateQuoteActivity.this, "Échec de connexion", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}
