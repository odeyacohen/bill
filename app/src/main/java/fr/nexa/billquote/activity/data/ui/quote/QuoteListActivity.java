package fr.nexa.billquote.activity.data.ui.quote;

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
import fr.nexa.billquote.activity.adapter.QuoteAdapter;
import fr.nexa.billquote.activity.data.model.Quote;
import fr.nexa.billquote.activity.data.remote.ApiClient;
import fr.nexa.billquote.activity.data.remote.QuoteService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private QuoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_list);

        recyclerView = findViewById(R.id.recyclerViewQuotes);
        progressBar = findViewById(R.id.progressBarQuotes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Quote> quoteList = new ArrayList<>();
        adapter = new QuoteAdapter(quoteList);

        recyclerView.setAdapter(adapter);
        Button buttonCreateQuote = findViewById(R.id.buttonCreateQuote);
        buttonCreateQuote.setOnClickListener(v -> {
            Intent intent = new Intent(QuoteListActivity.this, CreateQuoteActivity.class);
            startActivity(intent);
        });


        loadQuotes();
    }

    private void loadQuotes() {
        progressBar.setVisibility(View.VISIBLE);

        QuoteService service = ApiClient.getClient().create(QuoteService.class);
        service.getQuotes().enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setQuotes(response.body());
                } else {
                    Toast.makeText(QuoteListActivity.this, "Erreur de chargement", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(QuoteListActivity.this, "Échec de connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

