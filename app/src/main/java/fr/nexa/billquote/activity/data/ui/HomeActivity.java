package fr.nexa.billquote.activity.data.ui;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import fr.nexa.billquote.R;
import fr.nexa.billquote.activity.data.ui.client.ClientListActivity;
import fr.nexa.billquote.activity.data.ui.invoice.InvoiceListActivity;
import fr.nexa.billquote.activity.data.ui.quote.QuoteListActivity;

public class HomeActivity extends AppCompatActivity {

    private CalendarView calendarView;
    private Button buttonFacture, buttonDevis, buttonClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        calendarView = findViewById(R.id.calendarView);
        buttonFacture = findViewById(R.id.buttonFacture);
        buttonDevis = findViewById(R.id.buttonDevis);
        buttonClient = findViewById(R.id.buttonClient);

        // Listener pour la date
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
            Toast.makeText(HomeActivity.this, "Date sélectionnée : " + selectedDate, Toast.LENGTH_SHORT).show();
        });

        // Boutons pour naviguer
        buttonFacture.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, InvoiceListActivity.class);
            startActivity(intent);
        });

        buttonDevis.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, QuoteListActivity.class);
            startActivity(intent);
        });

        buttonClient.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ClientListActivity.class);
            startActivity(intent);
        });
    }
}
